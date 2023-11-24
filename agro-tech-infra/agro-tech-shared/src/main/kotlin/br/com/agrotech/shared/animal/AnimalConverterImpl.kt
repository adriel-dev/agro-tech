package br.com.agrotech.shared.animal

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.model.SexEnum
import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.persistence.animal.entity.AnimalEntity
import br.com.agrotech.persistence.animal.entity.SexEnumEntity
import br.com.agrotech.shared.breed.BreedConverter
import br.com.agrotech.shared.farm.FarmConverter
import br.com.agrotech.web.animal.dto.AnimalDTO
import br.com.agrotech.web.animal.dto.SexEnumDTO
import br.com.agrotech.web.animal.dto.request.SaveAnimalRequestDTO
import br.com.agrotech.web.animal.dto.response.BreedIdResponseDTO
import br.com.agrotech.web.animal.dto.response.FarmIdResponseDTO
import br.com.agrotech.web.animal.dto.response.FindAnimalByIdResponseDTO
import br.com.agrotech.web.animal.dto.response.SaveAnimalResponseDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class AnimalConverterImpl(
    private val breedConverter: BreedConverter,
    private val farmConverter: FarmConverter
) : AnimalConverter {

    override fun animalEntityToAnimal(animalEntity: AnimalEntity): Animal {
        return Animal(
            id = animalEntity.id,
            name = animalEntity.name,
            sex = animalEntity.sex?.let { SexEnum.valueOf(it.toString()) },
            acquisitionDate = animalEntity.acquisitionDate,
            saleDate = animalEntity.saleDate,
            acquisitionValue = animalEntity.acquisitionValue,
            saleValue = animalEntity.saleValue,
            breed = animalEntity.breed?.let { breedConverter.breedEntityToBreed(it) },
            farm = animalEntity.farm?.let { farmConverter.farmEntityToFarm(it) }
        )
    }

    override fun animalToAnimalEntity(animal: Animal): AnimalEntity {
        return AnimalEntity(
            id = animal.id,
            name = animal.name,
            sex = animal.sex?.let { SexEnumEntity.valueOf(it.toString()) },
            acquisitionDate = animal.acquisitionDate,
            saleDate = animal.saleDate,
            acquisitionValue = animal.acquisitionValue,
            saleValue = animal.saleValue,
            breed = animal.breed?.let { breedConverter.breedToBreedEntity(it) },
            farm = animal.farm?.let { farmConverter.farmToFarmEntity(it) }
        )
    }

    override fun animalDtoToAnimal(animalDTO: AnimalDTO): Animal {
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

    override fun animalToAnimalDto(animal: Animal): AnimalDTO {
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

    override fun saveAnimalRequestDtoToAnimal(saveAnimalRequestDTO: SaveAnimalRequestDTO): Animal {
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

    override fun animalToSaveAnimalResponseDto(animal: Animal): SaveAnimalResponseDTO {
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

    override fun animalToFindAnimalByIdResponseDto(animal: Animal): FindAnimalByIdResponseDTO {
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