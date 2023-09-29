package br.com.agrotech.domain.animal.port.api.usecase

import br.com.agrotech.domain.animal.model.Animal
import java.util.UUID

interface FindAnimalById {
    fun find(animalId: UUID): Animal
}