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
        this.name = farmEntity.name ?: this.name
        this.address = farmEntity.address ?: this.address
        this.city = farmEntity.city ?: this.city
        this.state = farmEntity.state ?: this.state
    }

}