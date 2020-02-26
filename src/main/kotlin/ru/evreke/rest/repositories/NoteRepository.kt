package ru.evreke.rest.repositories

import org.springframework.data.repository.CrudRepository
import ru.evreke.rest.entity.Note

interface NoteRepository : CrudRepository<Note, Long>