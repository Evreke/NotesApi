package ru.evreke.rest.entity

import kotlinx.serialization.Transient
import javax.persistence.*

@Entity
@Table(name = "roles")
data class Role(
    @Column(length = 255, unique = true, nullable = false)
    var name: String = "",
    var displayName: String = "",
    var description: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToMany(mappedBy = "roles")
    var users: Set<User> = mutableSetOf()

    @Transient
    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = [JoinColumn(name = "role_id")], inverseJoinColumns = [JoinColumn(name = "permission_id")])
    var permissions: MutableSet<Permission> = mutableSetOf()
}