package br.com.agrotech.domain.animal.port.spi.persistence

import br.com.agrotech.domain.animal.model.Animal
import java.util.UUID

interface AnimalRepository {
    fun saveAnimal(animal: Animal): Animal
    fun updateAnimal(animalId: UUID, animal: Animal): Animal
    fun findAnimalById(animalId: UUID): Animal
    fun findAllAnimals(): List<Animal>
    fun deleteAnimalById(animalId: UUID)
}