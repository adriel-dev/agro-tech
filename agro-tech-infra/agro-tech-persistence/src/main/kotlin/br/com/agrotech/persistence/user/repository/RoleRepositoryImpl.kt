package br.com.agrotech.persistence.user.repository

import br.com.agrotech.domain.user.model.Role
import br.com.agrotech.domain.user.port.spi.persistence.RoleRepository
import br.com.agrotech.persistence.user.converter.RolePersistenceConverter
import org.springframework.stereotype.Repository

@Repository
open class RoleRepositoryImpl(
    private val roleJpaRepository: RoleJpaRepository,
    private val roleConverter: RolePersistenceConverter
) : RoleRepository {

    override fun saveRole(role: Role): Role {
        val roleEntity = roleConverter.roleToRoleEntity(role)
        val savedRole = roleJpaRepository.save(roleEntity)
        return roleConverter.roleEntityToRole(savedRole)
    }

    override fun findRoleByName(roleName: String): Role {
        return roleConverter.roleEntityToRole(roleJpaRepository.findByName(roleName))
    }

}