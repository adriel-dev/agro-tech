package br.com.agrotech.web.qrcode.dto

import br.com.agrotech.web.animal.dto.AnimalDTO
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*

data class QrCodeDTO(
    val id: UUID? = null,
    val data: ByteArray? = null,
    @JsonIgnore
    val animal: AnimalDTO? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as QrCodeDTO

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
