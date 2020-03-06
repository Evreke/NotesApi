package ru.evreke.rest.entity

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email

@Entity
@Table(name = "users")
data class User(
    @Column(length = 255, unique = true, nullable = false)
    var username: String = "",
    @Column(length = 255, nullable = false)
    var password: String = "",
    @Email
    @Column(nullable = false)
    var email: String = "",
    var enabled: Boolean = false
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: MutableSet<Role> = mutableSetOf()
}