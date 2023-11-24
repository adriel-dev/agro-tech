package br.com.agrotech.web.animal.dto.response

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
    val farm: FarmIdResponseDTO? = null
)

data class BreedIdResponseDTO(
    val id: UUID? = null
)

data class FarmIdResponseDTO(
    val id: UUID? = null
)