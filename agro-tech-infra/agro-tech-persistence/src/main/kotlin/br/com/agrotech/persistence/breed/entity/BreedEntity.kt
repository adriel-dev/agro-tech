package br.com.agrotech.persistence.breed.entity

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.persistence.species.entity.SpeciesEntity
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "BREED")
class BreedEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null,
    @OneToOne
    var species: SpeciesEntity? = null
) {

    fun updateFrom(breedEntity: BreedEntity) {
        this.name = breedEntity.name
        this.species = breedEntity.species
    }

    fun toDomainBreed(): Breed {
        return Breed(
            this.id,
            this.name,
            this.species?.toDomainSpecies()
        )
    }

    companion object {
        fun fromDomainBreed(breed: Breed?): BreedEntity {
            return BreedEntity(
                breed?.id,
                breed?.name,
                SpeciesEntity.fromDomainSpecies(breed?.species)
            )
        }
    }

}