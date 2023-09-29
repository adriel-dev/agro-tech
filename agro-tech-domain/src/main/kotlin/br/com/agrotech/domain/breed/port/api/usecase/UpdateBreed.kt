package br.com.agrotech.domain.breed.port.api.usecase

import br.com.agrotech.domain.breed.model.Breed

interface UpdateBreed {
    fun updateBreed(breedId: String, breed: Breed): Breed
}