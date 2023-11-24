package br.com.agrotech.shared.user

import br.com.agrotech.domain.user.model.Role
import br.com.agrotech.persistence.user.entity.RoleEntity

interface RoleConverter {
    fun roleEntityToRole(roleEntity: RoleEntity): Role
    fun roleToRoleEntity(role: Role): RoleEntity
}