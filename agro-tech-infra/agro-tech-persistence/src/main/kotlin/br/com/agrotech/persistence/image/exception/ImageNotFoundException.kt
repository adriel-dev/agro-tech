package br.com.agrotech.persistence.image.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.*

class ImageNotFoundException(animalId: UUID) : NotFoundException("Image with AnimalID [${animalId}] was not found!")