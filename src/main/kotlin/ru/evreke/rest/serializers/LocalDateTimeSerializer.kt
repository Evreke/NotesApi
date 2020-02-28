package ru.evreke.rest.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import java.time.*

@Serializer(forClass = LocalDate::class)
object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor = StringDescriptor.withName("LocalDateSerializer")

    override fun serialize(encoder: Encoder, obj: LocalDateTime) = encoder.encodeLong(obj.atZone(ZoneId.systemDefault()).toEpochSecond())

    override fun deserialize(decoder: Decoder): LocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(decoder.decodeLong()), ZoneId.systemDefault())
}