package br.com.agrotech.domain.qrcode.model

import br.com.agrotech.domain.animal.model.Animal
import java.util.*

data class QrCode(
    var id: UUID? = null,
    var data: ByteArray? = null,
    var animal: Animal? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as QrCode

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
