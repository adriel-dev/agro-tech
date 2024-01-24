package br.com.agrotech.persistence.user.converter

import br.com.agrotech.domain.user.model.User
import br.com.agrotech.persistence.farm.converter.FarmPersistenceConverter
import br.com.agrotech.persistence.user.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserPersistenceConverter(
    private val farmConverter: FarmPersistenceConverter,
    private val roleConverter: RolePersistenceConverter
) {

    fun userEntityToUser(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            username = userEntity.agroUsername,
            password = userEntity.agroPassword,
            email = userEntity.email,
            farm = userEntity.farm?.let { farmConverter.farmEntityToFarm(it) },
            roles = userEntity.roles?.map { roleConverter.roleEntityToRole(it) }?.toMutableSet()
        )
    }

    fun userToUserEntity(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            agroUsername = user.username,
            agroPassword = user.password,
            email = user.email,
            farm = user.farm?.let { farmConverter.farmToFarmEntity(it) },
            roles = user.roles?.map { roleConverter.roleToRoleEntity(it) }?.toMutableSet()
        )
    }

}