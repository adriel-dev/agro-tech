package br.com.agrotech.persistence.species.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.UUID

class SpeciesNotFoundException(speciesId: UUID) : NotFoundException("Species with ID [$speciesId] was not found!")