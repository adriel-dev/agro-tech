package br.com.agrotech.persistence.farm.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.UUID

class FarmNotFoundException(farmId: UUID) : NotFoundException("Farm with ID [$farmId] was not found!")