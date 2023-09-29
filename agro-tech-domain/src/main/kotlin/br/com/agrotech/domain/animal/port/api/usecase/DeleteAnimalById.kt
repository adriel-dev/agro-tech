package br.com.agrotech.domain.animal.port.api.usecase

import java.util.UUID

interface DeleteAnimalById {
    fun delete(animalId: UUID)
}