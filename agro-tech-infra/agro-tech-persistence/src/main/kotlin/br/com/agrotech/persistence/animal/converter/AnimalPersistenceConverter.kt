package br.com.agrotech.persistence.animal.converter

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.model.SexEnum
import br.com.agrotech.persistence.animal.entity.AnimalEntity
import br.com.agrotech.persistence.animal.entity.SexEnumEntity
import br.com.agrotech.persistence.breed.converter.BreedPersistenceConverter
import br.com.agrotech.persistence.farm.converter.FarmPersistenceConverter
import org.springframework.stereotype.Component

@Component
class AnimalPersistenceConverter(
    private val breedConverter: BreedPersistenceConverter,
    private val farmConverter: FarmPersistenceConverter
) {

    fun animalEntityToAnimal(animalEntity: AnimalEntity): Animal {
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

    fun animalToAnimalEntity(animal: Animal): AnimalEntity {
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

}