package br.com.agrotech.domain.animal.model

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.farm.model.Farm
import java.time.LocalDate
import java.util.*

data class Animal(
    var id: UUID? = null,
    var externalId: String? = null,
    var name: String? = null,
    var sex: SexEnum? = null,
    var acquisitionDate: LocalDate? = null,
    var saleDate: LocalDate? = null,
    var acquisitionValue: Double? = null,
    var saleValue: Double? = null,
    var breed: Breed? = null,
    var farm: Farm? = null
)

enum class SexEnum {
    M, F
}