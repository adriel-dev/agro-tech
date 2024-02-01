package br.com.agrotech.domain.animal.port.spi.persistence

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.pagination.DomainPage
import java.util.UUID

interface AnimalRepository {
    fun saveAnimal(animal: Animal): Animal
    fun updateAnimal(animalId: UUID, animal: Animal): Animal
    fun findAnimalById(animalId: UUID): Animal
    fun findAllAnimals(farmId: UUID, page: Int, size: Int): DomainPage<Animal>
    fun deleteAnimalById(animalId: UUID)
}