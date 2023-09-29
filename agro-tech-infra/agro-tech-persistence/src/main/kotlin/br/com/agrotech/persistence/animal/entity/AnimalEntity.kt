package br.com.agrotech.persistence.animal.entity

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.model.SexEnum
import br.com.agrotech.persistence.breed.entity.BreedEntity
import br.com.agrotech.persistence.farm.entity.FarmEntity
import br.com.agrotech.persistence.monitoring.entity.MonitoringEntity
import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "ANIMAL")
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

    @OneToMany(mappedBy = "animal")
    var monitorings: List<MonitoringEntity>? = null,

    @ManyToOne @JoinColumn(name = "farm_id")
    var farm: FarmEntity? = null
) {

    fun updateFrom(animalEntity: AnimalEntity) {
        this.name = animalEntity.name
        this.sex = animalEntity.sex
        this.acquisitionDate = animalEntity.acquisitionDate
        this.saleDate = animalEntity.saleDate
        this.acquisitionValue = animalEntity.acquisitionValue
        this.saleValue = animalEntity.saleValue
        this.breed = animalEntity.breed
        this.monitorings = animalEntity.monitorings
        this.farm = animalEntity.farm
    }

    fun toDomainAnimal(): Animal {
        return Animal(
            this.id,
            this.name,
            SexEnum.valueOf(this.sex.toString()),
            this.acquisitionDate,
            this.saleDate,
            this.acquisitionValue,
            this.saleValue,
            this.breed?.toDomainBreed(),
            this.monitorings?.map { it.toDomainMonitoring() },
            this.farm?.toDomainFarm()
        )
    }

    companion object {
        fun fromDomainAnimal(animal: Animal?): AnimalEntity {
            return AnimalEntity(
                animal?.id,
                animal?.name,
                SexEnumEntity.valueOf(animal?.sex.toString()),
                animal?.acquisitionDate,
                animal?.saleDate,
                animal?.acquisitionValue,
                animal?.saleValue,
                BreedEntity.fromDomainBreed(animal?.breed),
                animal?.monitorings?.map { MonitoringEntity.fromDomainMonitoring(it) },
                FarmEntity.fromDomainFarm(animal?.farm)
            )
        }
    }

}


enum class SexEnumEntity {
    M, F
}