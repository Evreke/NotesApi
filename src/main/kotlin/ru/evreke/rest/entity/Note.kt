@file:UseSerializers(LocalDateTimeSerializer::class)

package ru.evreke.rest.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import ru.evreke.rest.serializers.LocalDateTimeSerializer
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Serializable
data class Note(
    var title: String? = null,
    var body: String? = null,
    var createdAt: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "group_id")
    var group: Group? = null
}