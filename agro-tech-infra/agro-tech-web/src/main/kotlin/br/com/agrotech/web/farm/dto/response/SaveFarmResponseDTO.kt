package br.com.agrotech.web.farm.dto.response

import br.com.agrotech.domain.farm.model.Farm
import java.util.*

data class SaveFarmResponseDTO(
    val id: UUID? = null,
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val owner: OwnerIdResponseDTO? = null
) {

    companion object {
        fun fromDomainFarm(farm: Farm): SaveFarmResponseDTO {
            return SaveFarmResponseDTO(
                id = farm.id,
                name = farm.name,
                address = farm.address,
                city = farm.city,
                state = farm.state,
                owner = OwnerIdResponseDTO(id = farm.owner?.id)
            )
        }
    }

}

data class OwnerIdResponseDTO(
    val id: UUID? = null
)