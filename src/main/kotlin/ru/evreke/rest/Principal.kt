package ru.evreke.rest

import org.springframework.security.core.authority.SimpleGrantedAuthority
import ru.evreke.rest.entity.Role
import ru.evreke.rest.entity.User
import java.util.*

class Principal(
    val user: User,
    accountNotExpired: Boolean = true,
    credentialsNotExpired: Boolean = true,
    accountNotLocked: Boolean = true
) : org.springframework.security.core.userdetails.User(
    user.username,
    user.password,
    user.enabled,
    accountNotExpired,
    credentialsNotExpired,
    accountNotLocked,
    getAuthorities(user.roles)
) {
    companion object {
        fun getAuthorities(roles: Set<Role>) = TreeSet(SimpleGrantedAuthorityComparator()).also {
            for (role in roles) {
                it.addAll(getGrantedAuthorities(role))
            }
        }

        private fun getGrantedAuthorities(role: Role) = role.permissions.map { SimpleGrantedAuthority(it.name) }.toSet()

        private class SimpleGrantedAuthorityComparator : Comparator<SimpleGrantedAuthority> {
            override fun compare(o1: SimpleGrantedAuthority, o2: SimpleGrantedAuthority) = if (o1 == o2) 0 else -1
        }
    }
}