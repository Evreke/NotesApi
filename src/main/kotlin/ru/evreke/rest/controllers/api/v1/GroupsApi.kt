package ru.evreke.rest.controllers.api.v1

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.evreke.rest.entity.Group
import ru.evreke.rest.exceptions.NotFoundException
import ru.evreke.rest.repositories.GroupRepository


@RestController
@RequestMapping("/api/v1/group")
class GroupsApi(
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
        return repo.findById(id).orElseThrow { NotFoundException("Group with id=${id} was not wound") }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postGroup(
        @RequestBody group: Group
    ): Group {
        return repo.save(group)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun putGroup(
        @RequestBody group: Group,
        @PathVariable id: Long
    ): Group {
        return repo.save(
            repo.findById(id).orElseThrow { NotFoundException("Group with id=${id} was not wound") }.apply {
                title = group.title
                notes = group.notes
            }
        )
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteGroup(
        @PathVariable id : Long
    ) {
        return repo.deleteById(id)
    }
}