package br.com.agrotech.domain.owner.port.api.usecase.impl

import br.com.agrotech.domain.owner.model.Owner
import br.com.agrotech.domain.owner.port.api.usecase.UpdateOwner
import br.com.agrotech.domain.owner.port.spi.persistence.OwnerRepository
import java.util.*

class UpdateOwnerUseCase(
    private val ownerRepository: OwnerRepository
) : UpdateOwner {

    override fun update(ownerId: UUID, owner: Owner): Owner {
        return ownerRepository.updateOwner(ownerId, owner)
    }

}