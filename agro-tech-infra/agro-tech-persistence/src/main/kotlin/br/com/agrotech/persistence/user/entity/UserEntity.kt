package br.com.agrotech.persistence.user.entity

import br.com.agrotech.persistence.farm.entity.FarmEntity
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

@Entity
@Table(name = "tb_user")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(name = "username", nullable = false, unique = true)
    var agroUsername: String? = null,

    @Column(name = "password", nullable = false)
    var agroPassword: String? = null,

    var email: String? = null,

    @ManyToOne
    var farm: FarmEntity? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tb_user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: MutableSet<RoleEntity>? = null
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

}