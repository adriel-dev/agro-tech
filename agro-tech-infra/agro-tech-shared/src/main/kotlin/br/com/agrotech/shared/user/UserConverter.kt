package br.com.agrotech.shared.user

import br.com.agrotech.domain.user.model.User
import br.com.agrotech.persistence.user.entity.UserEntity

interface UserConverter {
    fun userEntityToUser(userEntity: UserEntity): User
    fun userToUserEntity(user: User): UserEntity
}