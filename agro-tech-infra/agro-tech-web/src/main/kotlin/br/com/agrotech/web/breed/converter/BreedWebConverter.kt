package br.com.agrotech.web.breed.converter

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.web.breed.dto.BreedDTO
import br.com.agrotech.web.breed.dto.request.SaveBreedRequestDTO
import br.com.agrotech.web.breed.dto.response.SaveBreedResponseDTO
import br.com.agrotech.web.breed.dto.response.SpeciesIdResponseDTO
import br.com.agrotech.web.species.converter.SpeciesWebConverter
import org.springframework.stereotype.Component
import java.util.*

@Component
class BreedWebConverter(
    private val speciesConverter: SpeciesWebConverter
) {

    fun breedDtoToBreed(breedDTO: BreedDTO): Breed {
        return Breed(
            breedDTO.id,
            breedDTO.name,
            breedDTO.species?.let { speciesConverter.speciesDtoToSpecies(it) }
        )
    }

    fun breedToBreedDto(breed: Breed): BreedDTO {
        return BreedDTO(
            breed.id,
            breed.name,
            breed.species?.let { speciesConverter.speciesToSpeciesDto(it) }
        )
    }

    fun saveBreedRequestDtoToBreed(saveBreedRequestDTO: SaveBreedRequestDTO): Breed {
        return Breed(
            name = saveBreedRequestDTO.name,
            species = saveBreedRequestDTO.speciesId?.let { Species(id = UUID.fromString(it)) }
        )
    }

    fun breedToSaveBreedResponseDto(breed: Breed): SaveBreedResponseDTO {
        return SaveBreedResponseDTO(
            id = breed.id,
            name = breed.name,
            species = breed.species?.let { SpeciesIdResponseDTO(id = it.id) }
        )
    }

}