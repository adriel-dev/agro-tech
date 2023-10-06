package br.com.agrotech.web.animal.dto.response

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.web.animal.dto.SexEnumDTO
import java.time.LocalDate
import java.util.*

data class SaveAnimalResponseDTO(
    val id: UUID? = null,
    val name: String? = null,
    val sex: SexEnumDTO? = null,
    val acquisitionDate: LocalDate? = null,
    val saleDate: LocalDate? = null,
    val acquisitionValue: Double? = null,
    val saleValue: Double? = null,
    val breed: BreedIdResponseDTO? = null,
    val monitoringIds: List<String>? = listOf(),
    val farm: FarmIdResponseDTO? = null
) {

    companion object {
        fun fromDomainAnimal(animal: Animal): SaveAnimalResponseDTO {
            return SaveAnimalResponseDTO(
                id = animal.id,
                name = animal.name,
                sex = SexEnumDTO.valueOf(animal.sex.toString()),
                acquisitionDate = animal.acquisitionDate,
                acquisitionValue = animal.acquisitionValue,
                saleDate = animal.saleDate,
                saleValue = animal.saleValue,
                breed = BreedIdResponseDTO(animal.breed?.id),
                monitoringIds = animal.monitorings?.map { it.id.toString() },
                farm = FarmIdResponseDTO(animal.farm?.id)
            )
        }
    }

}

data class BreedIdResponseDTO(
    val id: UUID? = null
)

data class FarmIdResponseDTO(
    val id: UUID? = null
)