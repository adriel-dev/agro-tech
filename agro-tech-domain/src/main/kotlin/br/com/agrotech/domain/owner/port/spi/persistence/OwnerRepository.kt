package br.com.agrotech.domain.owner.port.spi.persistence

import br.com.agrotech.domain.owner.model.Owner
import java.util.*

interface OwnerRepository {
    fun saveOwner(owner: Owner): Owner
    fun updateOwner(ownerId: UUID, owner: Owner): Owner
    fun findOwnerById(ownerId: UUID): Owner
    fun findAllOwners(): List<Owner>
    fun deleteOwnerById(ownerId: UUID)
}