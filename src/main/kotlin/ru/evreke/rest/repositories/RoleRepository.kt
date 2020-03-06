package ru.evreke.rest.repositories

import org.springframework.data.repository.CrudRepository
import ru.evreke.rest.entity.Role

interface RoleRepository : CrudRepository<Role, Long>