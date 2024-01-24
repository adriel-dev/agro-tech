package br.com.agrotech.persistence.breed.converter

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.persistence.breed.entity.BreedEntity
import br.com.agrotech.persistence.species.converter.SpeciesPersistenceConverter
import org.springframework.stereotype.Component

@Component
class BreedPersistenceConverter(private val speciesConverter: SpeciesPersistenceConverter) {

    fun breedEntityToBreed(breedEntity: BreedEntity): Breed {
        return Breed(
            breedEntity.id,
            breedEntity.name,
            breedEntity.species?.let { speciesConverter.speciesEntityToSpecies(it) }
        )
    }

    fun breedToBreedEntity(breed: Breed): BreedEntity {
        return BreedEntity(
            breed.id,
            breed.name,
            breed.species?.let { speciesConverter.speciesToSpeciesEntity(it) }
        )
    }

}