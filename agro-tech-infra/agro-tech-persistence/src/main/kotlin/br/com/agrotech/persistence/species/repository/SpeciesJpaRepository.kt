package br.com.agrotech.persistence.species.repository

import br.com.agrotech.persistence.species.entity.SpeciesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SpeciesJpaRepository : JpaRepository<SpeciesEntity, UUID> {
}