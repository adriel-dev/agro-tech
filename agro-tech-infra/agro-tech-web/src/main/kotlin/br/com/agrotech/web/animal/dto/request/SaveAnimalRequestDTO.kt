package br.com.agrotech.web.animal.dto.request

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.model.SexEnum
import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.web.animal.dto.SexEnumDTO
import java.time.LocalDate
import java.util.*

data class SaveAnimalRequestDTO(
    val name: String? = null,
    val sex: SexEnumDTO? = null,
    val acquisitionDate: LocalDate? = null,
    val saleDate: LocalDate? = null,
    val acquisitionValue: Double? = null,
    val saleValue: Double? = null,
    val breedId: String? = null,
    val farmId: String? = null
) {

    fun toDomainAnimal(): Animal {
        return Animal(
            name = this.name,
            sex = SexEnum.valueOf(this.sex.toString()),
            acquisitionDate = this.acquisitionDate,
            acquisitionValue = this.acquisitionValue,
            saleDate = this.saleDate,
            saleValue = this.saleValue,
            breed = Breed(id = UUID.fromString(this.breedId)),
            farm = Farm(id = UUID.fromString(farmId))
        )
    }

}