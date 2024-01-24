package br.com.agrotech.web.qrcode.converter

import br.com.agrotech.domain.qrcode.model.QrCode
import br.com.agrotech.web.animal.converter.AnimalWebConverter
import br.com.agrotech.web.qrcode.dto.QrCodeDTO
import org.springframework.stereotype.Component

@Component
class QrCodeWebConverter(
    private val animalConverter: AnimalWebConverter
) {

    fun qrCodeDtoToQrCode(qrCodeDTO: QrCodeDTO): QrCode {
        return QrCode(
            id = qrCodeDTO.id,
            data = qrCodeDTO.data,
            animal = qrCodeDTO.animal?.let { animalConverter.animalDtoToAnimal(it) }
        )
    }

    fun qrCodeToQrCodeDto(qrCode: QrCode): QrCodeDTO {
        return QrCodeDTO(
            id = qrCode.id,
            data = qrCode.data,
            animal = qrCode.animal?.let { animalConverter.animalToAnimalDto(it) }
        )
    }

}