package br.com.agrotech.persistence.user.repository

import br.com.agrotech.domain.user.model.Role
import br.com.agrotech.domain.user.port.spi.persistence.RoleRepository
import br.com.agrotech.persistence.user.entity.RoleEntity

class RoleRepositoryImpl(
    private val roleJpaRepository: RoleJpaRepository
) : RoleRepository {

    override fun saveRole(role: Role): Role {
        val roleEntity = RoleEntity.fromDomainRole(role)
        return roleJpaRepository.save(roleEntity).toDomainRole()
    }

}