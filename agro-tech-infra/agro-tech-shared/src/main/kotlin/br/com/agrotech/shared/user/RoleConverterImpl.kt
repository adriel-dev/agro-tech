package br.com.agrotech.shared.user

import br.com.agrotech.domain.user.model.Role
import br.com.agrotech.persistence.user.entity.RoleEntity
import org.springframework.stereotype.Component

@Component
class RoleConverterImpl : RoleConverter {

    override fun roleEntityToRole(roleEntity: RoleEntity): Role {
        return Role(
            roleEntity.id,
            roleEntity.name
        )
    }

    override fun roleToRoleEntity(role: Role): RoleEntity {
        return RoleEntity(
            role.id,
            role.name
        )
    }

}