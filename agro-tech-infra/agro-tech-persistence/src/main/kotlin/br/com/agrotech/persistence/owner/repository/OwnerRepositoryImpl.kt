package br.com.agrotech.persistence.owner.repository

import br.com.agrotech.persistence.owner.exception.OwnerNotFoundException
import br.com.agrotech.domain.owner.model.Owner
import br.com.agrotech.domain.owner.port.spi.persistence.OwnerRepository
import br.com.agrotech.persistence.owner.entity.OwnerEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
open class OwnerRepositoryImpl(
    private val ownerJpaRepository: OwnerJpaRepository
) : OwnerRepository {

    override fun saveOwner(owner: Owner): Owner {
        return ownerJpaRepository.save(OwnerEntity.fromDomainOwner(owner)).toDomainOwner()
    }

    override fun updateOwner(ownerId: UUID, owner: Owner): Owner {
        val foundOwner = ownerJpaRepository.findById(ownerId).orElseThrow { OwnerNotFoundException(ownerId) }
        foundOwner.updateFrom(OwnerEntity.fromDomainOwner(owner))
        return ownerJpaRepository.save(foundOwner).toDomainOwner()
    }

    override fun findOwnerById(ownerId: UUID): Owner {
        val foundOwner = ownerJpaRepository.findById(ownerId).orElseThrow { OwnerNotFoundException(ownerId) }
        return foundOwner.toDomainOwner()
    }

    override fun findAllOwners(): List<Owner> {
        return ownerJpaRepository.findAll().map { it.toDomainOwner() }
    }

    override fun deleteOwnerById(ownerId: UUID) {
        return ownerJpaRepository.deleteById(ownerId)
    }
}
