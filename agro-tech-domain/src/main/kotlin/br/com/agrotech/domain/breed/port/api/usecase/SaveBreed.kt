package br.com.agrotech.domain.breed.port.api.usecase

import br.com.agrotech.domain.breed.model.Breed

interface SaveBreed {
    fun save(breed: Breed): Breed
}