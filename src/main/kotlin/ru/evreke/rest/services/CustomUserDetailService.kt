package ru.evreke.rest.services

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.evreke.rest.entity.User
import ru.evreke.rest.repositories.UserRepository

@Service
class CustomUserDetailService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
        if(user == null) {
            throw UsernameNotFoundException(username)
        }
        return CustomUserDetails(user)
    }
}

class CustomUserDetails(
    private val user: User
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val roles = user.roles
        val authorities = arrayListOf<SimpleGrantedAuthority>()
        roles?.forEach {
            authorities.add(SimpleGrantedAuthority(it.title))
        }
        return authorities
    }

    override fun isEnabled(): Boolean {
        return user.enabled
    }

    override fun getUsername(): String {
        return user.username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

}
