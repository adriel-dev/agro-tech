package br.com.agrotech.shared.qrcode

import br.com.agrotech.domain.qrcode.model.QrCode
import br.com.agrotech.persistence.qrcode.entity.QrCodeEntity
import br.com.agrotech.shared.animal.AnimalConverter
import br.com.agrotech.web.qrcode.dto.QrCodeDTO
import org.springframework.stereotype.Component

@Component
class QrCodeConverterImpl(private val animalConverter: AnimalConverter) : QrCodeConverter {

    override fun qrCodeEntityToQrCode(qrCodeEntity: QrCodeEntity): QrCode {
        return QrCode(
            id = qrCodeEntity.id,
            data = qrCodeEntity.data,
            animal = qrCodeEntity.animal?.let { animalConverter.animalEntityToAnimal(it) }
        )
    }

    override fun qrCodeToQrCodeEntity(qrCode: QrCode): QrCodeEntity {
        return QrCodeEntity(
            id = qrCode.id,
            data = qrCode.data,
            animal = qrCode.animal?.let { animalConverter.animalToAnimalEntity(it) }
        )
    }

    override fun qrCodeDtoToQrCode(qrCodeDTO: QrCodeDTO): QrCode {
        return QrCode(
            id = qrCodeDTO.id,
            data = qrCodeDTO.data,
            animal = qrCodeDTO.animal?.let { animalConverter.animalDtoToAnimal(it) }
        )
    }

    override fun qrCodeToQrCodeDto(qrCode: QrCode): QrCodeDTO {
        return QrCodeDTO(
            id = qrCode.id,
            data = qrCode.data,
            animal = qrCode.animal?.let { animalConverter.animalToAnimalDto(it) }
        )
    }

}