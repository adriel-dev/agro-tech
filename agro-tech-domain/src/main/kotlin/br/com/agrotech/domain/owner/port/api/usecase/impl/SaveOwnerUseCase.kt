package br.com.agrotech.domain.owner.port.api.usecase.impl

import br.com.agrotech.domain.owner.model.Owner
import br.com.agrotech.domain.owner.port.api.usecase.SaveOwner
import br.com.agrotech.domain.owner.port.spi.persistence.OwnerRepository

class SaveOwnerUseCase(
    private val ownerRepository: OwnerRepository
) : SaveOwner {

    override fun save(owner: Owner): Owner {
        return ownerRepository.saveOwner(owner)
    }

}