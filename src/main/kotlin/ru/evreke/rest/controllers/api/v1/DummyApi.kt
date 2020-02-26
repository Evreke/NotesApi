package ru.evreke.rest.controllers.api.v1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.evreke.rest.entity.Group
import ru.evreke.rest.exceptions.DummyNotFoundException
import ru.evreke.rest.repositories.GroupRepository


@RestController
@RequestMapping("/api/v1/dummy")
class DummyApi(
    val repo: GroupRepository
) {
    @GetMapping("")
    fun getAll(): List<Group> {
        return repo.findAll().toList()
    }

    @GetMapping("/{id}")
    fun getAll(
        @PathVariable("id") id: Long
    ): Group {
        return repo.findById(id).orElseThrow { DummyNotFoundException("Dummy with id=${id} was not wound") }
    }
}