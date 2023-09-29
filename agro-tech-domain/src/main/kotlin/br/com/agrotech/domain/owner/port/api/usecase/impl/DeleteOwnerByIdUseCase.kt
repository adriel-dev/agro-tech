package br.com.agrotech.domain.owner.port.api.usecase.impl

import br.com.agrotech.domain.owner.port.api.usecase.DeleteOwnerById
import br.com.agrotech.domain.owner.port.spi.persistence.OwnerRepository
import java.util.*

class DeleteOwnerByIdUseCase(
    private val ownerRepository: OwnerRepository
) : DeleteOwnerById {

    override fun delete(ownerId: UUID) {
        ownerRepository.deleteOwnerById(ownerId)
    }

}