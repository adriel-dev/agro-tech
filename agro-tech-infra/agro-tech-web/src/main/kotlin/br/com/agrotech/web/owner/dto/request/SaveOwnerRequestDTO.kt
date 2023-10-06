package br.com.agrotech.web.owner.dto.request

import br.com.agrotech.domain.owner.model.Owner
import java.time.LocalDate

data class SaveOwnerRequestDTO(
    val name: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null
) {

    fun toDomainOwner(): Owner {
        return Owner(
            name = this.name,
            lastName = this.lastName,
            birthDate = this.birthDate
        )
    }

}
