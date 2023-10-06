package br.com.agrotech.persistence.user.entity

import br.com.agrotech.domain.user.model.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "ROLE")
open class RoleEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    open var id: UUID? = null,
    @Column(nullable = false, unique = true)
    open var name: String? = null
) {

    fun toDomainRole(): Role {
        return Role(
            this.id,
            this.name
        )
    }

    companion object {
        fun fromDomainRole(role: Role): RoleEntity {
            return RoleEntity(
                role.id,
                role.name
            )
        }
    }

}