package br.com.agrotech.persistence.farm.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_farm")
class FarmEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var name: String? = null,
    var address: String? = null,
    var city: String? = null,
    var state: String? = null
) {

    fun updateFrom(farmEntity: FarmEntity) {
        farmEntity.name?.let { this.name = it }
        farmEntity.address?.let { this.address = it }
        farmEntity.city?.let { this.city = it }
        farmEntity.state?.let { this.state = it }
    }

}