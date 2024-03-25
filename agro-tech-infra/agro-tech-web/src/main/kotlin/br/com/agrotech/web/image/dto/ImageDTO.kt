package br.com.agrotech.web.image.dto

import br.com.agrotech.web.animal.dto.AnimalDTO
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*

data class ImageDTO(
    val id: UUID? = null,
    val type: String? = null,
    val filePath: String? = null,
    var fileExtension: String? = null,
    @JsonIgnore
    val animal: AnimalDTO? = null
)