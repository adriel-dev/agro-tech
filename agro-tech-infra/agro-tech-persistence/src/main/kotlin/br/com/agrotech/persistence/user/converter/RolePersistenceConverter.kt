package br.com.agrotech.persistence.user.converter

import br.com.agrotech.domain.user.model.Role
import br.com.agrotech.persistence.user.entity.RoleEntity
import org.springframework.stereotype.Component

@Component
class RolePersistenceConverter {

    fun roleEntityToRole(roleEntity: RoleEntity): Role {
        return Role(
            roleEntity.id,
            roleEntity.name
        )
    }

    fun roleToRoleEntity(role: Role): RoleEntity {
        return RoleEntity(
            role.id,
            role.name
        )
    }

}