package br.com.agrotech.domain.animal.port.api.usecase

import java.util.UUID

interface FindAnimalById {
    fun find(animalId: UUID): Map<String, Any>
}