package br.com.agrotech.domain.owner.port.api.usecase

import br.com.agrotech.domain.owner.model.Owner
import java.util.*

interface FindOwnerById {
    fun find(ownerId: UUID): Owner
}