package br.com.agrotech.web.breed.dto

import br.com.agrotech.web.species.dto.SpeciesDTO
import java.util.*

class BreedDTO(
    val id: UUID? = null,
    val name: String? = null,
    val species: SpeciesDTO? = null
)