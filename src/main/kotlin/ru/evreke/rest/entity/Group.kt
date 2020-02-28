@file:UseSerializers(LocalDateSerializer::class)

package ru.evreke.rest.entity

import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import ru.evreke.rest.serializers.LocalDateSerializer
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "groups")
@Serializable
data class Group(
    var title: String? = null,
    var createdAt: LocalDate = LocalDate.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "group", cascade = [CascadeType.REMOVE])
    var notes: List<Note> = listOf()
}