package br.com.agrotech.domain.user.port.api.usecase.impl

import br.com.agrotech.domain.user.model.User
import br.com.agrotech.domain.user.port.api.usecase.RegisterUser
import br.com.agrotech.domain.user.port.spi.persistence.UserRepository

class RegisterUserUseCase(
    private val userRepository: UserRepository
) : RegisterUser {

    override fun register(user: User): User {
        return userRepository.saveUser(user)
    }

}