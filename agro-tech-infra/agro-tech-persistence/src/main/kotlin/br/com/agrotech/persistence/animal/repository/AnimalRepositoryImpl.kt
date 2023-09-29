package br.com.agrotech.persistence.animal.repository

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import br.com.agrotech.persistence.animal.entity.AnimalEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class AnimalRepositoryImpl(
    private val animalJpaRepository: AnimalJpaRepository
) : AnimalRepository {

    override fun saveAnimal(animal: Animal): Animal {
       return animalJpaRepository.save(AnimalEntity.fromDomainAnimal(animal)).toDomainAnimal()
    }

    override fun updateAnimal(animalId: UUID, animal: Animal): Animal {
        val foundAnimal = animalJpaRepository.findById(animalId).orElseThrow { RuntimeException("Animal with id [$animalId] does not exist!") }
        foundAnimal.updateFrom(AnimalEntity.fromDomainAnimal(animal))
        return animalJpaRepository.save(foundAnimal).toDomainAnimal()
    }

    override fun findAnimalById(animalId: UUID): Animal {
        return animalJpaRepository.findById(animalId).get().toDomainAnimal()
    }

    override fun findAllAnimals(): List<Animal> {
        return animalJpaRepository.findAll().map { it.toDomainAnimal() }
    }

    override fun deleteAnimalById(animalId: UUID) {
        return animalJpaRepository.deleteById(animalId)
    }

}