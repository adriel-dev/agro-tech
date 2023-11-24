package br.com.agrotech.domain.breed.port.api.usecase

import br.com.agrotech.domain.breed.model.Breed
import java.util.*

interface FindBreedById {
    fun find(breedId: UUID): Breed
}