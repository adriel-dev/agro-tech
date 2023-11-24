package br.com.agrotech.domain.image.model

import br.com.agrotech.domain.animal.model.Animal
import java.util.*

data class Image(
    var id: UUID? = null,
    var type: String? = null,
    var filePath: String? = null,
    var fileExtension: String? = null,
    var animal: Animal? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}