package ru.evreke.rest.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    val email: String,
    val password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val firstName: String? = null
    val lastName: String? = null
    val enabled = false
    @Column(nullable = false, unique = true)
    val username : String = ""

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    val roles: Set<Role>? = null
}