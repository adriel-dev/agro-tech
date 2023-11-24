package br.com.agrotech.shared.breed

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.persistence.breed.entity.BreedEntity
import br.com.agrotech.web.breed.dto.BreedDTO
import br.com.agrotech.web.breed.dto.request.SaveBreedRequestDTO
import br.com.agrotech.web.breed.dto.response.SaveBreedResponseDTO

interface BreedConverter {
    fun breedEntityToBreed(breedEntity: BreedEntity): Breed
    fun breedToBreedEntity(breed: Breed): BreedEntity
    fun breedDtoToBreed(breedDTO: BreedDTO): Breed
    fun breedToBreedDto(breed: Breed): BreedDTO
    fun saveBreedRequestDtoToBreed(saveBreedRequestDTO: SaveBreedRequestDTO): Breed
    fun breedToSaveBreedResponseDto(breed: Breed): SaveBreedResponseDTO
}