package br.com.agrotech.persistence.breed.entity

import br.com.agrotech.persistence.species.entity.SpeciesEntity
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_breed")
class BreedEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null,
    @OneToOne
    var species: SpeciesEntity? = null
) {

    fun updateFrom(breedEntity: BreedEntity) {
        this.name = breedEntity.name ?: this.name
        this.species = breedEntity.species ?: this.species
    }

}