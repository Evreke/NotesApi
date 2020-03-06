package ru.evreke.rest.repositories

import org.springframework.data.repository.CrudRepository
import ru.evreke.rest.entity.User
import java.util.*

interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): Optional<User>

}
