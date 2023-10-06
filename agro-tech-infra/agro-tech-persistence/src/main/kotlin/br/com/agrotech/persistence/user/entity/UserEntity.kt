package br.com.agrotech.persistence.user.entity

import br.com.agrotech.domain.user.model.User
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

@Entity
@Table(name = "AGRO_USER")
open class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    open var id: UUID? = null,

    @Column(name = "username", nullable = false, unique = true)
    open var agroUsername: String? = null,

    @Column(name = "password", nullable = false)
    open var agroPassword: String? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    open var roles: MutableSet<RoleEntity>? = null
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.roles?.map { SimpleGrantedAuthority(it.name) }?.toMutableSet() ?: mutableSetOf()
    }

    override fun getPassword(): String? {
        return this.agroPassword
    }

    override fun getUsername(): String? {
        return this.agroUsername
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun toDomainUser(): User {
        return User(
            this.id,
            this.agroUsername,
            this.agroPassword,
            this.roles?.map { it.toDomainRole() }?.toMutableSet()
        )
    }

    companion object {
        fun fromDomainUser(user: User): UserEntity {
            return UserEntity(
                user.id,
                user.agroUsername,
                user.agroPassword,
                user.roles?.map { RoleEntity.fromDomainRole(it) }?.toMutableSet()
            )
        }
    }

}