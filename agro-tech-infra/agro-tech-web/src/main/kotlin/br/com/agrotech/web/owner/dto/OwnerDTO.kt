package br.com.agrotech.web.owner.dto

import br.com.agrotech.domain.owner.model.Owner
import java.time.LocalDate
import java.util.*

class OwnerDTO(
    val id: UUID? = null,
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null
) {

    fun toDomainOwner(): Owner {
        return Owner(
            this.id,
            this.name,
            this.lastName,
            this.birthDate
        )
    }

    companion object {
        fun fromDomainOwner(owner: Owner): OwnerDTO {
            return OwnerDTO(
                owner.id,
                owner.name,
                owner.lastName,
                owner.birthDate
            )
        }
    }

}