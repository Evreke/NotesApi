package ru.evreke.rest.services

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.evreke.rest.Principal
import ru.evreke.rest.repositories.UserRepository

@Service
@Transactional(readOnly = true)
class UserDetailsService(
    private val userRepo: UserRepository
) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String) =
        Principal(userRepo.findByUsername(username).orElseThrow { UsernameNotFoundException("User not found") })
}