package br.com.agrotech.persistence.species.repository

import br.com.agrotech.domain.species.model.Species
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository
import br.com.agrotech.persistence.species.entity.SpeciesEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class SpeciesRepositoryImpl(
    private val speciesJpaRepository: SpeciesJpaRepository
) : SpeciesRepository {

    override fun saveSpecies(species: Species): Species {
        return speciesJpaRepository.save(SpeciesEntity.fromDomainSpecies(species)).toDomainSpecies()
    }

    override fun updateSpecies(speciesId: UUID, species: Species): Species {
        val foundSpecies = speciesJpaRepository.findById(speciesId)
            .orElseThrow { RuntimeException("Species with id [$speciesId] does not exist!") }
        foundSpecies.updateFrom(SpeciesEntity.fromDomainSpecies(species))
        return speciesJpaRepository.save(foundSpecies).toDomainSpecies()
    }

    override fun findSpeciesById(speciesId: UUID): Species {
        return speciesJpaRepository.findById(speciesId).get().toDomainSpecies()
    }

    override fun findAllSpecies(): List<Species> {
        return speciesJpaRepository.findAll().map { it.toDomainSpecies() }
    }

    override fun deleteSpeciesById(speciesId: UUID) {
        return speciesJpaRepository.deleteById(speciesId)
    }
}
