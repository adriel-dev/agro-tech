package br.com.agrotech.web.species.converter

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.web.species.dto.SpeciesDTO
import br.com.agrotech.web.species.dto.request.SaveSpeciesRequestDTO
import org.springframework.stereotype.Component

@Component
class SpeciesWebConverter {

    fun speciesDtoToSpecies(speciesDTO: SpeciesDTO): Species {
        return Species(
            speciesDTO.id,
            speciesDTO.name
        )
    }

    fun speciesToSpeciesDto(species: Species): SpeciesDTO {
        return SpeciesDTO(
            species.id,
            species.name
        )
    }

    fun saveSpeciesRequestDtoToSpecies(saveSpeciesRequestDTO: SaveSpeciesRequestDTO): Species {
        return Species(
            name = saveSpeciesRequestDTO.name
        )
    }

}