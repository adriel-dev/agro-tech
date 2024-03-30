package br.com.agrotech.persistence.species.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_species")
class SpeciesEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null
) {

    fun updateFrom(speciesEntity: SpeciesEntity) {
        speciesEntity.name?.let { this.name = it }
    }

}