package br.com.agrotech.shared.species

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.persistence.species.entity.SpeciesEntity
import br.com.agrotech.web.species.dto.SpeciesDTO
import br.com.agrotech.web.species.dto.request.SaveSpeciesRequestDTO
import org.springframework.stereotype.Component

@Component
class SpeciesConverterImpl : SpeciesConverter {

    override fun speciesEntityToSpecies(speciesEntity: SpeciesEntity): Species {
        return Species(
            speciesEntity.id,
            speciesEntity.name
        )
    }

    override fun speciesToSpeciesEntity(species: Species): SpeciesEntity {
        return SpeciesEntity(
            species.id,
            species.name
        )
    }

    override fun speciesDtoToSpecies(speciesDTO: SpeciesDTO): Species {
        return Species(
            speciesDTO.id,
            speciesDTO.name
        )
    }

    override fun speciesToSpeciesDto(species: Species): SpeciesDTO {
        return SpeciesDTO(
            species.id,
            species.name
        )
    }

    override fun saveSpeciesRequestDtoToSpecies(saveSpeciesRequestDTO: SaveSpeciesRequestDTO): Species {
        return Species(
            name = saveSpeciesRequestDTO.name
        )
    }

}