package br.com.agrotech.persistence.farm.repository

import br.com.agrotech.persistence.farm.entity.FarmEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FarmJpaRepository : JpaRepository<FarmEntity, UUID> {
}