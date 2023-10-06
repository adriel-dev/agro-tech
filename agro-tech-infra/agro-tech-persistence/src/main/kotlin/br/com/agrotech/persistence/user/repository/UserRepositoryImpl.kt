package br.com.agrotech.persistence.user.repository

import br.com.agrotech.domain.user.model.User
import br.com.agrotech.domain.user.port.spi.persistence.UserRepository
import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.persistence.user.exception.UserAlreadyExistsException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Repository

@Repository
open class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {

    override fun saveUser(user: User): User {
        try {
            return userJpaRepository.save(UserEntity.fromDomainUser(user)).toDomainUser()
        } catch (e: DataIntegrityViolationException) {
            throw UserAlreadyExistsException(user.agroUsername!!)
        }
    }

}