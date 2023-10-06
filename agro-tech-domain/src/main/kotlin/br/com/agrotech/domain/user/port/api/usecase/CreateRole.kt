package br.com.agrotech.domain.user.port.api.usecase

import br.com.agrotech.domain.user.model.Role

interface CreateRole {
    fun create(role: Role): Role
}