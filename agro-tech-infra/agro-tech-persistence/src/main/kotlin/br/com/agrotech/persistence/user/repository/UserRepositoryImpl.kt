package br.com.agrotech.persistence.user.repository

import br.com.agrotech.domain.user.model.User
import br.com.agrotech.domain.user.port.spi.persistence.UserRepository
import br.com.agrotech.persistence.user.converter.UserPersistenceConverter
import br.com.agrotech.persistence.user.exception.UserAlreadyExistsException
import br.com.agrotech.persistence.user.exception.UserNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Repository

@Repository
open class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository,
    private val userConverter: UserPersistenceConverter
) : UserRepository {

    override fun saveUser(user: User): User {
        try {
            val savedUser = userJpaRepository.save(userConverter.userToUserEntity(user))
            return userConverter.userEntityToUser(savedUser)
        } catch (e: DataIntegrityViolationException) {
            throw UserAlreadyExistsException(user.username!!)
        }
    }

    override fun findUserByUsername(username: String): User {
        val userEntity =  userJpaRepository.findByAgroUsername(username).orElseThrow { UserNotFoundException(username) }
        return userConverter.userEntityToUser(userEntity)
    }

}