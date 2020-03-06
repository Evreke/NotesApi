package ru.evreke.rest.entity

import javax.persistence.*

@Entity
@Table(name = "permissions")
data class Permission(
    @Column(length = 255, unique = true, nullable = false)
    var name: String = "",
    var description: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToMany(mappedBy = "permissions")
    var roles: Set<Role> = mutableSetOf()
}