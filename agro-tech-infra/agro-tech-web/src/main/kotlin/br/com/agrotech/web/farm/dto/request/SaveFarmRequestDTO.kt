package br.com.agrotech.web.farm.dto.request

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.domain.owner.model.Owner
import java.util.*

data class SaveFarmRequestDTO(
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val ownerId: String? = null
) {

    fun toDomainFarm(): Farm {
        return Farm(
            name = this.name,
            address = this.address,
            city = this.city,
            state = this.state,
            owner = Owner(id = UUID.fromString(this.ownerId))
        )
    }

}