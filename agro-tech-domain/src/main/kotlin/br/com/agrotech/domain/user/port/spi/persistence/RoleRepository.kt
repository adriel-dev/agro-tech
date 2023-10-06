package br.com.agrotech.domain.user.port.spi.persistence

import br.com.agrotech.domain.user.model.Role

interface RoleRepository {
    fun saveRole(role: Role): Role
}