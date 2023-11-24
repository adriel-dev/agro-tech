package br.com.agrotech.web.user.impl

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import br.com.agrotech.domain.user.model.User
import br.com.agrotech.domain.user.port.api.usecase.RegisterFirstUser
import br.com.agrotech.domain.user.port.spi.persistence.UserRepository
import br.com.agrotech.persistence.user.exception.UserAlreadyExistsException
import br.com.agrotech.persistence.user.exception.UserNotFoundException
import org.springframework.transaction.annotation.Transactional

open class RegisterFirstUserUseCase(
    private val userRepository: UserRepository,
    private val farmRepository: FarmRepository
) : RegisterFirstUser {

    @Transactional
    override fun register(farm: Farm, user: User): User {
        val username = user.username!!
        if(checkIfUserExists(username)) {
            throw UserAlreadyExistsException(username)
        } else {
            val savedFarm = farmRepository.saveFarm(farm)
            user.farm = savedFarm
            return userRepository.saveUser(user)
        }
    }

    private fun checkIfUserExists(username: String): Boolean {
        return try {
            userRepository.findUserByUsername(username)
            true
        } catch (e: UserNotFoundException) {
            false
        }
    }

}