package br.com.agrotech.persistence.breed.repository

import br.com.agrotech.persistence.breed.entity.BreedEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BreedJpaRepository : JpaRepository<BreedEntity, UUID> {
}