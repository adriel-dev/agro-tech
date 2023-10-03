package br.com.agrotech.persistence.owner.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.UUID

class OwnerNotFoundException(ownerId: UUID) : NotFoundException("Owner with ID [$ownerId] was not found!")