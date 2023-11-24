package br.com.agrotech.web.animal.dto.request

import br.com.agrotech.web.animal.dto.SexEnumDTO
import java.time.LocalDate

data class SaveAnimalRequestDTO(
    val name: String? = null,
    val sex: SexEnumDTO? = null,
    val acquisitionDate: LocalDate? = null,
    val saleDate: LocalDate? = null,
    val acquisitionValue: Double? = null,
    val saleValue: Double? = null,
    val breedId: String? = null,
    val farmId: String? = null
)