package br.com.agrotech.persistence.breed.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.*

class BreedNotFoundException(breedId: UUID) : NotFoundException("Breed with ID [$breedId] was not found!")