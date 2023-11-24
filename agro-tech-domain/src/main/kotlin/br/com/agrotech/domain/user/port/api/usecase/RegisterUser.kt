package br.com.agrotech.domain.user.port.api.usecase

import br.com.agrotech.domain.user.model.User

interface RegisterUser {
    fun register(user: User): User
}