package br.com.agrotech.persistence.user.repository

import br.com.agrotech.persistence.user.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RoleJpaRepository : JpaRepository<RoleEntity, UUID> {
}