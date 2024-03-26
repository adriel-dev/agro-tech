package br.com.agrotech.web.animal.dto.response

import br.com.agrotech.web.animal.dto.SexEnumDTO
import br.com.agrotech.web.breed.dto.BreedDTO
import br.com.agrotech.web.farm.dto.FarmDTO
import java.time.LocalDate
import java.util.*

data class FindAllAnimalsResponseDTO(
    val id: UUID? = null,
    var externalId: String? = null,
    val name: String? = null,
    val sex: SexEnumDTO? = null,
    val acquisitionDate: LocalDate? = null,
    val saleDate: LocalDate? = null,
    val acquisitionValue: Double? = null,
    val saleValue: Double? = null,
    val breed: BreedDTO? = null,
    val farm: FarmDTO? = null,
    val imagePath: String? = null
)
