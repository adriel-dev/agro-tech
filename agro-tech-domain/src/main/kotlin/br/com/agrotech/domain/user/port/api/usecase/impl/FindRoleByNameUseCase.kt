package br.com.agrotech.domain.user.port.api.usecase.impl

import br.com.agrotech.domain.user.model.Role
import br.com.agrotech.domain.user.port.api.usecase.FindRoleByName
import br.com.agrotech.domain.user.port.spi.persistence.RoleRepository

class FindRoleByNameUseCase(
    private val roleRepository: RoleRepository
) : FindRoleByName {

    override fun find(roleName: String): Role {
        return roleRepository.findRoleByName(roleName)
    }

}