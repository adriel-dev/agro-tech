package br.com.agrotech.persistence.animal.repository

import br.com.agrotech.persistence.animal.entity.AnimalEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AnimalJpaRepository : JpaRepository<AnimalEntity, UUID> {
    fun findAllByFarmIdOrderByCreatedDateDesc(farmId: UUID, pageable: Pageable): Page<AnimalEntity>
    fun findAnimalByFarmIdAndExternalId(farmId: UUID, externalId: String): AnimalEntity
    fun findAllByFarmIdAndNameOrderByCreatedDateDesc(farmId: UUID, name: String, pageable: Pageable): Page<AnimalEntity>
    fun findAllByFarmIdAndBreedSpeciesIdInOrderByCreatedDateDesc(farmId: UUID, breedsIds: List<UUID>, pageable: Pageable): Page<AnimalEntity>
}