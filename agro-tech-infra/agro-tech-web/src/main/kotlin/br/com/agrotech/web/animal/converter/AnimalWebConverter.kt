package br.com.agrotech.web.animal.converter

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.model.SexEnum
import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.SexEnumDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.BreedIdResponseDTO
import br.com.agrotech.web.animal.dto.response.FarmIdResponseDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import br.com.agrotech.web.breed.converter.BreedWebConverter
import br.com.agrotech.web.farm.converter.FarmWebConverter
import org.springframework.stereotype.Component
import java.util.*

@Component
class AnimalWebConverter(
    private val breedConverter: BreedWebConverter,
    private val farmConverter: FarmWebConverter
) {

    fun animalDtoToAnimal(animalDTO: AnimalDTO): Animal {
        return Animal(
            id = animalDTO.id,
            name = animalDTO.name,
            sex = animalDTO.sex?.let { SexEnum.valueOf(it.toString()) },
            acquisitionDate = animalDTO.acquisitionDate,
            saleDate = animalDTO.saleDate,
            acquisitionValue = animalDTO.acquisitionValue,
            saleValue = animalDTO.saleValue,
            breed = animalDTO.breed?.let { breedConverter.breedDtoToBreed(it) },
            farm = animalDTO.farm?.let { farmConverter.farmDtoToFarm(it) }
        )
    }

    fun animalToAnimalDto(animal: Animal): AnimalDTO {
        return AnimalDTO(
            id = animal.id,
            name = animal.name,
            sex = animal.sex?.let { SexEnumDTO.valueOf(it.toString()) },
            acquisitionDate = animal.acquisitionDate,
            saleDate = animal.saleDate,
            acquisitionValue = animal.acquisitionValue,
            saleValue = animal.saleValue,
            breed = animal.breed?.let { breedConverter.breedToBreedDto(it) },
            farm = animal.farm?.let { farmConverter.farmToFarmDto(it) }
        )
    }

    fun saveAnimalRequestDtoToAnimal(saveAnimalRequestDTO: SaveAnimalRequestDTO): Animal {
        return Animal(
            name = saveAnimalRequestDTO.name,
            sex = saveAnimalRequestDTO.sex?.let { SexEnum.valueOf(it.toString()) },
            acquisitionDate = saveAnimalRequestDTO.acquisitionDate,
            acquisitionValue = saveAnimalRequestDTO.acquisitionValue,
            saleDate = saveAnimalRequestDTO.saleDate,
            saleValue = saveAnimalRequestDTO.saleValue,
            breed = saveAnimalRequestDTO.breedId?.let { Breed(id = UUID.fromString(it)) },
            farm = saveAnimalRequestDTO.farmId?.let { Farm(id = UUID.fromString(it)) }
        )
    }

    fun animalToSaveAnimalResponseDto(animal: Animal): SaveAnimalResponseDTO {
        return SaveAnimalResponseDTO(
            id = animal.id,
            name = animal.name,
            sex = animal.sex?.let { SexEnumDTO.valueOf(it.toString()) },
            acquisitionDate = animal.acquisitionDate,
            acquisitionValue = animal.acquisitionValue,
            saleDate = animal.saleDate,
            saleValue = animal.saleValue,
            breed = BreedIdResponseDTO(animal.breed?.id),
            farm = FarmIdResponseDTO(animal.farm?.id)
        )
    }

    fun animalToFindAnimalByIdResponseDto(animal: Animal): FindAnimalByIdResponseDTO {
        return FindAnimalByIdResponseDTO(
            id = animal.id,
            name = animal.name,
            sex = animal.sex?.let { SexEnumDTO.valueOf(it.toString()) },
            acquisitionDate = animal.acquisitionDate,
            saleDate = animal.saleDate,
            acquisitionValue = animal.acquisitionValue,
            saleValue = animal.saleValue,
            breed = animal.breed?.let { breedConverter.breedToBreedDto(it) },
            farm = animal.farm?.let { farmConverter.farmToFarmDto(it) }
        )
    }

}