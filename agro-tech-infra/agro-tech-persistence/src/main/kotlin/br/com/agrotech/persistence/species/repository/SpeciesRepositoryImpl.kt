package br.com.agrotech.persistence.species.repository

import br.com.agrotech.persistence.species.exception.SpeciesNotFoundException
import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository
import br.com.agrotech.persistence.species.converter.SpeciesPersistenceConverter
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class SpeciesRepositoryImpl(
    private val speciesJpaRepository: SpeciesJpaRepository,
    private val speciesConverter: SpeciesPersistenceConverter
) : SpeciesRepository {

    override fun saveSpecies(species: Species): Species {
        val savedSpecies = speciesJpaRepository.save(speciesConverter.speciesToSpeciesEntity(species))
        return speciesConverter.speciesEntityToSpecies(savedSpecies)
    }

    override fun updateSpecies(speciesId: UUID, species: Species): Species {
        val foundSpecies = speciesJpaRepository.findById(speciesId).orElseThrow { SpeciesNotFoundException(speciesId) }
        foundSpecies.updateFrom(speciesConverter.speciesToSpeciesEntity(species))
        val savedSpecies = speciesJpaRepository.save(foundSpecies)
        return speciesConverter.speciesEntityToSpecies(savedSpecies)
    }

    override fun findSpeciesById(speciesId: UUID): Species {
        val foundSpecies = speciesJpaRepository.findById(speciesId).orElseThrow { SpeciesNotFoundException(speciesId) }
        return speciesConverter.speciesEntityToSpecies(foundSpecies)
    }

    override fun findAllSpecies(): List<Species> {
        return speciesJpaRepository.findAll().map { speciesConverter.speciesEntityToSpecies(it) }
    }

    override fun deleteSpeciesById(speciesId: UUID) {
        return speciesJpaRepository.deleteById(speciesId)
    }
}
