package ru.evreke.rest.repositories

import org.springframework.data.repository.CrudRepository
import ru.evreke.rest.entity.Group

interface GroupRepository : CrudRepository<Group, Long>