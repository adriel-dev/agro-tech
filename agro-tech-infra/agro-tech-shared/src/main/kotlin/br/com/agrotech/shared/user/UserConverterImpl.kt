package br.com.agrotech.shared.user

import br.com.agrotech.domain.user.model.User
import br.com.agrotech.persistence.user.entity.UserEntity
import br.com.agrotech.shared.farm.FarmConverter
import org.springframework.stereotype.Component

@Component
class UserConverterImpl(
    private val farmConverter: FarmConverter,
    private val roleConverter: RoleConverter
) : UserConverter {

    override fun userEntityToUser(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            username = userEntity.agroUsername,
            password = userEntity.agroPassword,
            email = userEntity.email,
            farm = userEntity.farm?.let { farmConverter.farmEntityToFarm(it) },
            roles = userEntity.roles?.map { roleConverter.roleEntityToRole(it) }?.toMutableSet()
        )
    }

    override fun userToUserEntity(user: User): UserEntity {
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