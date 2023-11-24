package br.com.agrotech.domain.breed.port.api.usecase

import br.com.agrotech.domain.breed.model.Breed
import java.util.*

interface UpdateBreed {
    fun update(breedId: UUID, breed: Breed): Breed
}