package br.com.agrotech.shared.animal

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.persistence.animal.entity.AnimalEntity
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO

interface AnimalConverter {
    fun animalEntityToAnimal(animalEntity: AnimalEntity): Animal
    fun animalToAnimalEntity(animal: Animal): AnimalEntity
    fun animalDtoToAnimal(animalDTO: AnimalDTO): Animal
    fun animalToAnimalDto(animal: Animal): AnimalDTO
    fun saveAnimalRequestDtoToAnimal(saveAnimalRequestDTO: SaveAnimalRequestDTO): Animal
    fun animalToSaveAnimalResponseDto(animal: Animal): SaveAnimalResponseDTO
    fun animalToFindAnimalByIdResponseDto(animal: Animal): FindAnimalByIdResponseDTO
}