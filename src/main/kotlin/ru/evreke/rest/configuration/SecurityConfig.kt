package ru.evreke.rest.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import ru.evreke.rest.services.CustomUserDetailService

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val customUserDetailService: CustomUserDetailService
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .cors()
            .and()
            .csrf().disable()
            .authorizeRequests().antMatchers("/api/v1/**").authenticated()
            .and()
            .httpBasic()

    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        return DaoAuthenticationProvider().also {
            it.setPasswordEncoder(passwordEncoder())
            it.setUserDetailsService(customUserDetailService)
        }
    }

    @Bean
    fun passwordEncoderAndMatcher(): PasswordEncoder {
        return object : PasswordEncoder {
            override fun encode(rawPassword: CharSequence?): String {
                return passwordEncoder().encode(rawPassword)
            }

            override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
                return passwordEncoder().matches(rawPassword, encodedPassword)
            }
        }
    }
}