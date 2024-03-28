package br.com.agrotech.domain.animal.port.api.usecase.impl

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.api.usecase.FindAllAnimals
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import br.com.agrotech.domain.pagination.DomainPage
import java.util.*

class FindAllAnimalsUseCase(
    private val animalRepository: AnimalRepository
) : FindAllAnimals {

    override fun find(
        farmId: UUID, page: Int, size: Int,
        breedsIds: List<UUID>?, animalName: String?, externalId: String?
    ): DomainPage<Animal> {
        return when {
            externalId != null -> animalRepository.findAnimalByExternalId(farmId, externalId)
            animalName != null -> animalRepository.findAllAnimalsByName(farmId, page, size, animalName)
            breedsIds != null -> animalRepository.findAllAnimalsByBreeds(farmId, page, size, breedsIds)
            else -> animalRepository.findAllAnimals(farmId, page, size)
        }
    }

}