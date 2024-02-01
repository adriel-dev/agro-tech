package br.com.agrotech.persistence.animal.repository

import br.com.agrotech.persistence.animal.exception.AnimalNotFoundException
import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.persistence.animal.converter.AnimalPersistenceConverter
import br.com.agrotech.persistence.animal.entity.AnimalEntity
import br.com.agrotech.persistence.breed.converter.BreedPersistenceConverter
import br.com.agrotech.persistence.breed.exception.BreedNotFoundException
import br.com.agrotech.persistence.breed.repository.BreedJpaRepository
import br.com.agrotech.persistence.farm.converter.FarmPersistenceConverter
import br.com.agrotech.persistence.farm.exception.FarmNotFoundException
import br.com.agrotech.persistence.farm.repository.FarmJpaRepository
import br.com.agrotech.persistence.image.repository.ImageJpaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Repository
open class AnimalRepositoryImpl(
    private val animalJpaRepository: AnimalJpaRepository,
    private val animalConverter: AnimalPersistenceConverter,
    private val breedJpaRepository: BreedJpaRepository,
    private val breedConverter: BreedPersistenceConverter,
    private val farmJpaRepository: FarmJpaRepository,
    private val farmConverter: FarmPersistenceConverter,
    private val imageJpaRepository: ImageJpaRepository
) : AnimalRepository {

    override fun saveAnimal(animal: Animal): Animal {
        val breedId = animal.breed?.id!!
        val farmId = animal.farm?.id!!
        val fullBreed = breedJpaRepository.findById(breedId).orElseThrow { BreedNotFoundException(breedId = breedId) }
        val fullFarm = farmJpaRepository.findById(farmId).orElseThrow { FarmNotFoundException(farmId = farmId) }
        animal.breed = breedConverter.breedEntityToBreed(fullBreed)
        animal.farm = farmConverter.farmEntityToFarm(fullFarm)
        val animalEntity = animalConverter.animalToAnimalEntity(animal)
        val savedAnimal = animalJpaRepository.save(animalEntity)
        return animalConverter.animalEntityToAnimal(savedAnimal)
    }

    override fun updateAnimal(animalId: UUID, animal: Animal): Animal {
        val foundAnimal = animalJpaRepository.findById(animalId).orElseThrow { AnimalNotFoundException(animalId) }
        foundAnimal.updateFrom(animalConverter.animalToAnimalEntity(animal))
        val updatedAnimal = animalJpaRepository.save(foundAnimal)
        return animalConverter.animalEntityToAnimal(updatedAnimal)
    }

    override fun findAnimalById(animalId: UUID): Animal {
        val foundAnimal = animalJpaRepository.findById(animalId).orElseThrow { AnimalNotFoundException(animalId) }
        return animalConverter.animalEntityToAnimal(foundAnimal)
    }

    override fun findAllAnimals(farmId: UUID, page: Int, size: Int): DomainPage<Animal> {
        val pageable: Pageable = PageRequest.of(page, size)
        val animalsPage: Page<AnimalEntity> = animalJpaRepository.findAllByFarmId(farmId, pageable)
        val animalList = animalsPage.map { animalConverter.animalEntityToAnimal(it) }.toList()
        return DomainPage(animalList, animalsPage.totalPages, animalsPage.totalElements, animalsPage.size, animalsPage.number)
    }

    @Transactional
    override fun deleteAnimalById(animalId: UUID) {
        imageJpaRepository.deleteByAnimalId(animalId)
        return animalJpaRepository.deleteById(animalId)
    }

}