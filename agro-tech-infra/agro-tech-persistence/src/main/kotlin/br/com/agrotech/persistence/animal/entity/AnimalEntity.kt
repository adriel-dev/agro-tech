package br.com.agrotech.persistence.animal.entity

import br.com.agrotech.persistence.breed.entity.BreedEntity
import br.com.agrotech.persistence.farm.entity.FarmEntity
import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "tb_animal")
class AnimalEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    var name: String? = null,
    var sex: SexEnumEntity? = null,

    var acquisitionDate: LocalDate? = null,

    var saleDate: LocalDate? = null,

    var acquisitionValue: Double? = null,
    var saleValue: Double? = null,

    @ManyToOne @JoinColumn(name = "breed_id")
    var breed: BreedEntity? = null,

    @ManyToOne @JoinColumn(name = "farm_id")
    var farm: FarmEntity? = null
) {

    fun updateFrom(animalEntity: AnimalEntity) {
        this.name = animalEntity.name ?: this.name
        this.sex = animalEntity.sex ?: this.sex
        this.acquisitionDate = animalEntity.acquisitionDate ?: this.acquisitionDate
        this.saleDate = animalEntity.saleDate ?: this.saleDate
        this.acquisitionValue = animalEntity.acquisitionValue ?: acquisitionValue
        this.saleValue = animalEntity.saleValue ?: this.saleValue
        this.breed = animalEntity.breed ?: this.breed
        this.farm = animalEntity.farm ?: this.farm
    }

}


enum class SexEnumEntity {
    M, F
}