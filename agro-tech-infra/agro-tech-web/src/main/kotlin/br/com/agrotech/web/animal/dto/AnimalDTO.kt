package br.com.agrotech.web.animal.dto

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.model.SexEnum
import br.com.agrotech.domain.monitoring.model.Monitoring
import br.com.agrotech.web.breed.dto.BreedDTO
import br.com.agrotech.web.farm.dto.FarmDTO
import java.time.LocalDate
import java.util.*

class AnimalDTO(
    val id: UUID? = null,
    val name: String? = null,
    val sex: SexEnumDTO? = null,
    val acquisitionDate: LocalDate? = null,
    val saleDate: LocalDate? = null,
    val acquisitionValue: Double? = null,
    val saleValue: Double? = null,
    val breed: BreedDTO? = null,
    val monitorings: List<Monitoring>? = null,
    val farm: FarmDTO? = null
) {

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
            this.monitorings,
            this.farm?.toDomainFarm()
        )
    }

    companion object {
        fun fromDomainAnimal(animal: Animal): AnimalDTO {
            return AnimalDTO(
                animal.id,
                animal.name,
                SexEnumDTO.valueOf(animal.sex.toString()),
                animal.acquisitionDate,
                animal.saleDate,
                animal.acquisitionValue,
                animal.saleValue,
                BreedDTO.fromDomainBreed(animal.breed!!),
                animal.monitorings,
                FarmDTO.fromDomainFarm(animal.farm!!)
            )
        }
    }

}

enum class SexEnumDTO {
    M, F
}