package br.com.agrotech.web.animal.dto.response

import br.com.agrotech.web.animal.dto.SexEnumDTO
import br.com.agrotech.web.breed.dto.BreedDTO
import br.com.agrotech.web.farm.dto.FarmDTO
import br.com.agrotech.web.qrcode.dto.QrCodeDTO
import java.time.LocalDate
import java.util.*

data class FindAnimalByIdResponseDTO(
    val id: UUID? = null,
    var externalId: String? = null,
    val name: String? = null,
    val sex: SexEnumDTO? = null,
    val acquisitionDate: LocalDate? = null,
    val saleDate: LocalDate? = null,
    val acquisitionValue: Double? = null,
    val saleValue: Double? = null,
    val breed: BreedDTO? = null,
    val farm: FarmDTO? = null,
    var image: ByteArray? = null,
    var qrCode: QrCodeDTO? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FindAnimalByIdResponseDTO

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}