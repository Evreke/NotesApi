package ru.evreke.rest.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "groups")
data class Group(
    var title: String? = null,
    var createdAt: LocalDate = LocalDate.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "group")
    val notes : List<Note> = listOf()
}