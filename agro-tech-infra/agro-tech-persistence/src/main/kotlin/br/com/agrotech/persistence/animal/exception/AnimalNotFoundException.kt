package br.com.agrotech.persistence.animal.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.UUID

class AnimalNotFoundException(animalId: UUID) : NotFoundException("Animal with ID [${animalId}] was not found!")