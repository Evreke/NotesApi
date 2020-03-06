package ru.evreke.rest.repositories

import org.springframework.data.repository.CrudRepository
import ru.evreke.rest.entity.Permission

interface PermissionRepository : CrudRepository<Permission, Long>