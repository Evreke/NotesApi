package ru.evreke.rest.entity

import javax.persistence.*

@Entity
@Table(name = "permissions")
class Permission(
    val title: String? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToMany(mappedBy = "permissions")
    val roles: Collection<Role>? = null
}