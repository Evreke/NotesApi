package ru.evreke.rest.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import java.time.LocalDate

@Serializer(forClass = LocalDate::class)
object LocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor = StringDescriptor.withName("LocalDateSerializer")

    override fun serialize(encoder: Encoder, obj: LocalDate) = encoder.encodeLong(obj.toEpochDay())

    override fun deserialize(decoder: Decoder): LocalDate = LocalDate.ofEpochDay(decoder.decodeLong())
}