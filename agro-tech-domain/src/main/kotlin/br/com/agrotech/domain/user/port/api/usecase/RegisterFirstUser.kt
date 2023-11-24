package br.com.agrotech.domain.user.port.api.usecase

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.user.model.User

interface RegisterFirstUser {
    fun register(farm: Farm, user: User): User
}