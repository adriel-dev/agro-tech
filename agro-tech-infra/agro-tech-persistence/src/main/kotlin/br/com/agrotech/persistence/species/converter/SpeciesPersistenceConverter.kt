package br.com.agrotech.persistence.species.converter

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.persistence.species.entity.SpeciesEntity
import org.springframework.stereotype.Component

@Component
class SpeciesPersistenceConverter {

    fun speciesEntityToSpecies(speciesEntity: SpeciesEntity): Species {
        return Species(
            speciesEntity.id,
            speciesEntity.name
        )
    }

    fun speciesToSpeciesEntity(species: Species): SpeciesEntity {
        return SpeciesEntity(
            species.id,
            species.name
        )
    }

}