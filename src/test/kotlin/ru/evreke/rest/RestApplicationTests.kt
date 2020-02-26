package ru.evreke.rest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.evreke.rest.entity.Group
import ru.evreke.rest.entity.Note
import ru.evreke.rest.repositories.GroupRepository
import ru.evreke.rest.repositories.NoteRepository

@SpringBootTest
class RestApplicationTests {
    @Autowired
    lateinit var groupRepo: GroupRepository
    @Autowired
    lateinit var notesRepo : NoteRepository

    @Test
    fun contextLoads() {
        testCase()
    }

    fun testCase() {
        val group = groupRepo.save(
            Group("Test")
        )

        val note = Note("Note Title", "Note Body...")
        note.group = group

        notesRepo.save(note)
    }

}
