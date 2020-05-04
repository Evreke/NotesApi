package ru.evreke.rest.repositories

import org.springframework.data.repository.CrudRepository
import ru.evreke.rest.entity.User

interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(email: String) : User
}