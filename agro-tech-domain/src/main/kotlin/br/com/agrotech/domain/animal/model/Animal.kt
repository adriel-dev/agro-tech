package br.com.agrotech.domain.animal.model

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.monitoring.model.Monitoring
import java.time.LocalDate
import java.util.*

data class Animal(
    var id: UUID? = null,
    var name: String? = null,
    var sex: SexEnum? = null,
    var acquisitionDate: LocalDate? = null,
    var saleDate: LocalDate? = null,
    var acquisitionValue: Double? = null,
    var saleValue: Double? = null,
    var breed: Breed? = null,
    var monitorings: List<Monitoring>? = null,
    var farm: Farm? = null
)

enum class SexEnum {
    M, F
}