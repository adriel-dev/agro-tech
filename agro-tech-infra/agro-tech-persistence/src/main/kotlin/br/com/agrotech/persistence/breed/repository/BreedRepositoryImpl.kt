package br.com.agrotech.persistence.breed.repository

import br.com.agrotech.persistence.breed.exception.BreedNotFoundException
import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import br.com.agrotech.persistence.breed.converter.BreedPersistenceConverter
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class BreedRepositoryImpl(
    private val breedJpaRepository: BreedJpaRepository,
    private val breedConverter: BreedPersistenceConverter
) : BreedRepository {

    override fun saveBreed(breed: Breed): Breed {
        val savedBreed = breedJpaRepository.save(breedConverter.breedToBreedEntity(breed))
        return breedConverter.breedEntityToBreed(savedBreed)
    }

    override fun updateBreed(breedId: UUID, breed: Breed): Breed {
        val foundBreed = breedJpaRepository.findById(breedId).orElseThrow { BreedNotFoundException(breedId) }
        foundBreed.updateFrom(breedConverter.breedToBreedEntity(breed))
        val savedBreed = breedJpaRepository.save(foundBreed)
        return breedConverter.breedEntityToBreed(savedBreed)
    }

    override fun findBreedById(breedId: UUID): Breed {
        val foundBreed = breedJpaRepository.findById(breedId).orElseThrow { BreedNotFoundException(breedId) }
        return breedConverter.breedEntityToBreed(foundBreed)
    }

    override fun findAllBreeds(): List<Breed> {
        return breedJpaRepository.findAll().map { breedConverter.breedEntityToBreed(it) }
    }

    override fun deleteBreedById(breedId: UUID) {
        return breedJpaRepository.deleteById(breedId)
    }
}
