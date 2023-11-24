package br.com.agrotech.domain.user.port.api.usecase.impl

import br.com.agrotech.domain.user.model.Role
import br.com.agrotech.domain.user.port.api.usecase.CreateRole
import br.com.agrotech.domain.user.port.spi.persistence.RoleRepository

class CreateRoleUseCase(
    private val roleRepository: RoleRepository
) : CreateRole {

    override fun create(role: Role): Role {
        role.name = role.name?.uppercase()
        return roleRepository.saveRole(role)
    }

}