package br.com.agrotech.persistence.owner.repository

import br.com.agrotech.persistence.owner.entity.OwnerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OwnerJpaRepository : JpaRepository<OwnerEntity, UUID> {
}