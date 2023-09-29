package br.com.agrotech.domain.animal.model

import br.com.agrotech.domain.breed.model.Breed
import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.monitoring.model.Monitoring
import java.time.LocalDate
import java.util.*

data class Animal(
    val id: UUID? = null,
    val name: String? = null,
    val sex: SexEnum? = null,
    val acquisitionDate: LocalDate? = null,
    val saleDate: LocalDate? = null,
    val acquisitionValue: Double? = null,
    val saleValue: Double? = null,
    val breed: Breed? = null,
    val monitorings: List<Monitoring>? = null,
    val farm: Farm? = null
)

enum class SexEnum {
    M, F
}