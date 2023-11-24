package br.com.agrotech.shared.species

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.persistence.species.entity.SpeciesEntity
import br.com.agrotech.web.species.dto.SpeciesDTO
import br.com.agrotech.web.species.dto.request.SaveSpeciesRequestDTO

interface SpeciesConverter {
    fun speciesEntityToSpecies(speciesEntity: SpeciesEntity): Species
    fun speciesToSpeciesEntity(species: Species): SpeciesEntity
    fun speciesDtoToSpecies(speciesDTO: SpeciesDTO): Species
    fun speciesToSpeciesDto(species: Species): SpeciesDTO
    fun saveSpeciesRequestDtoToSpecies(saveSpeciesRequestDTO: SaveSpeciesRequestDTO): Species
}