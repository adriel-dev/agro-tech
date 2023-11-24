package br.com.agrotech.shared.breed

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.persistence.breed.entity.BreedEntity
import br.com.agrotech.shared.species.SpeciesConverter
import br.com.agrotech.web.breed.dto.BreedDTO
import br.com.agrotech.web.breed.dto.request.SaveBreedRequestDTO
import br.com.agrotech.web.breed.dto.response.SaveBreedResponseDTO
import br.com.agrotech.web.breed.dto.response.SpeciesIdResponseDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class BreedConverterImpl(private val speciesConverter: SpeciesConverter) : BreedConverter {

    override fun breedEntityToBreed(breedEntity: BreedEntity): Breed {
        return Breed(
            breedEntity.id,
            breedEntity.name,
            breedEntity.species?.let { speciesConverter.speciesEntityToSpecies(it) }
        )
    }

    override fun breedToBreedEntity(breed: Breed): BreedEntity {
        return BreedEntity(
            breed.id,
            breed.name,
            breed.species?.let { speciesConverter.speciesToSpeciesEntity(it) }
        )
    }

    override fun breedDtoToBreed(breedDTO: BreedDTO): Breed {
        return Breed(
            breedDTO.id,
            breedDTO.name,
            breedDTO.species?.let { speciesConverter.speciesDtoToSpecies(it) }
        )
    }

    override fun breedToBreedDto(breed: Breed): BreedDTO {
        return BreedDTO(
            breed.id,
            breed.name,
            breed.species?.let { speciesConverter.speciesToSpeciesDto(it) }
        )
    }

    override fun saveBreedRequestDtoToBreed(saveBreedRequestDTO: SaveBreedRequestDTO): Breed {
        return Breed(
            name = saveBreedRequestDTO.name,
            species = saveBreedRequestDTO.speciesId?.let { Species(id = UUID.fromString(it)) }
        )
    }

    override fun breedToSaveBreedResponseDto(breed: Breed): SaveBreedResponseDTO {
        return SaveBreedResponseDTO(
            id = breed.id,
            name = breed.name,
            species = breed.species?.let { SpeciesIdResponseDTO(id = it.id) }
        )
    }

}