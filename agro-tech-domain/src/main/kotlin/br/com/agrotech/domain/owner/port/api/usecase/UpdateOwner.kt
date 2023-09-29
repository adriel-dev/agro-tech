package br.com.agrotech.domain.owner.port.api.usecase

import br.com.agrotech.domain.owner.model.Owner
import java.util.*

interface UpdateOwner {
    fun update(ownerId: UUID, owner: Owner): Owner
}