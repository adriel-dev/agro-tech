package br.com.agrotech.domain.owner.port.api.usecase.impl

import br.com.agrotech.domain.owner.model.Owner
import br.com.agrotech.domain.owner.port.api.usecase.FindOwnerById
import br.com.agrotech.domain.owner.port.spi.persistence.OwnerRepository
import java.util.*

class FindOwnerByIdUseCase(
    private val ownerRepository: OwnerRepository
) : FindOwnerById {

    override fun find(ownerId: UUID): Owner {
        return ownerRepository.findOwnerById(ownerId)
    }

}