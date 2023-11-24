package br.com.agrotech.persistence.image.repository

import br.com.agrotech.persistence.image.entity.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface ImageJpaRepository : JpaRepository<ImageEntity, UUID> {
    fun findByAnimalId(animalId: UUID): Optional<ImageEntity>
    fun deleteByAnimalId(animalId: UUID)
}