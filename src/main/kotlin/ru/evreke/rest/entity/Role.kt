package ru.evreke.rest.entity

import javax.persistence.*


@Entity
@Table(name = "roles")
class Role(
    val title: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToMany(mappedBy = "roles")
    val users: Collection<User>? = null

    @ManyToMany
    @JoinTable(
        name = "roles_permissions",
        joinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "permission_id", referencedColumnName = "id")]
    )
    val permissions: Collection<Permission>? = null
}