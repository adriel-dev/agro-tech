package br.com.agrotech.persistence.species.entity

import br.com.agrotech.domain.species.model.Species
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "SPECIES")
class SpeciesEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null
) {

    fun updateFrom(speciesEntity: SpeciesEntity) {
        this.name = speciesEntity.name
    }

    fun toDomainSpecies(): Species {
        return Species(
            this.id,
            this.name
        )
    }

    companion object {
        fun fromDomainSpecies(species: Species?): SpeciesEntity {
            return SpeciesEntity(
                species?.id,
                species?.name
            )
        }
    }

}