package ru.evreke.rest.controllers.api.v1

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.evreke.rest.entity.Note
import ru.evreke.rest.exceptions.NotFoundException
import ru.evreke.rest.repositories.NoteRepository


@RestController
@RequestMapping("/api/v1/note")
class NotesApi(
    val repo: NoteRepository
) {
    @GetMapping("")
    fun getAll(): List<Note> {
        return repo.findAll().toList()
    }

    @GetMapping("/{id}")
    fun getAll(
        @PathVariable("id") id: Long
    ): Note {
        return repo.findById(id).orElseThrow { NotFoundException("Note with id=${id} was not wound") }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postNote(
        @RequestBody group: Note
    ): Note {
        return repo.save(group)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun putNote(
        @RequestBody note: Note,
        @PathVariable id: Long
    ): Note {
        return repo.save(
            repo.findById(id).orElseThrow { NotFoundException("Note with id=${id} was not wound") }.apply {
                title = note.title
                body = note.body
                group = note.group
            }
        )
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteNote(
        @PathVariable id: Long
    ) {
        return repo.deleteById(id)
    }
}