package br.com.agrotech.domain.breed.port.api.usecase

import java.util.UUID

interface DeleteBreedById {
    fun delete(breedId: UUID)
}