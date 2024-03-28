package br.com.agrotech.domain.animal.port.api.usecase

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.pagination.DomainPage
import java.util.*

interface FindAllAnimals {
    fun find(farmId: UUID, page: Int, size: Int, speciesIds: List<UUID>?, animalName: String?, externalId: String?): DomainPage<Animal>
}