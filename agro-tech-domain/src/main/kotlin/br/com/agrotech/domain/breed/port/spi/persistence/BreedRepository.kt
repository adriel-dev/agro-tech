package br.com.agrotech.domain.breed.port.spi.persistence

import br.com.agrotech.domain.breed.model.Breed
import java.util.UUID

interface BreedRepository {
    fun findAllBreeds(): List<Breed>
    fun findBreedById(breedId: UUID): Breed
    fun saveBreed(breed: Breed): Breed
    fun updateBreed(breedId: UUID, breed: Breed): Breed
    fun deleteBreedById(breedId: UUID)
}