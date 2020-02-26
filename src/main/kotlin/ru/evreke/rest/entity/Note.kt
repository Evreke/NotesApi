package ru.evreke.rest.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Note(
    var title: String? = null,
    var body: String? = null,
    var createdAt: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null

    @ManyToOne
    @JoinColumn(name = "group_id")
    var group : Group? = null
}