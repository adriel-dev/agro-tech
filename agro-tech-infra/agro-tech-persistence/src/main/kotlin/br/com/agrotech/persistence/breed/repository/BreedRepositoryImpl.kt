package br.com.agrotech.persistence.breed.repository

import br.com.agrotech.persistence.breed.exception.BreedNotFoundException
import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import br.com.agrotech.persistence.breed.entity.BreedEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class BreedRepositoryImpl(
    private val breedJpaRepository: BreedJpaRepository
) : BreedRepository {

    override fun saveBreed(breed: Breed): Breed {
        return breedJpaRepository.save(BreedEntity.fromDomainBreed(breed)).toDomainBreed()
    }

    override fun updateBreed(breedId: UUID, breed: Breed): Breed {
        val foundBreed = breedJpaRepository.findById(breedId).orElseThrow { BreedNotFoundException(breedId) }
        foundBreed.updateFrom(BreedEntity.fromDomainBreed(breed))
        return breedJpaRepository.save(foundBreed).toDomainBreed()
    }

    override fun findBreedById(breedId: UUID): Breed {
        val foundBreed = breedJpaRepository.findById(breedId).orElseThrow { BreedNotFoundException(breedId) }
        return foundBreed.toDomainBreed()
    }

    override fun findAllBreeds(): List<Breed> {
        return breedJpaRepository.findAll().map { it.toDomainBreed() }
    }

    override fun deleteBreedById(breedId: UUID) {
        return breedJpaRepository.deleteById(breedId)
    }
}
