package br.com.agrotech.persistence.qrcode.converter

import br.com.agrotech.domain.qrcode.model.QrCode
import br.com.agrotech.persistence.animal.converter.AnimalPersistenceConverter
import br.com.agrotech.persistence.qrcode.entity.QrCodeEntity
import org.springframework.stereotype.Component

@Component
class QrCodePersistenceConverter(private val animalConverter: AnimalPersistenceConverter) {

    fun qrCodeEntityToQrCode(qrCodeEntity: QrCodeEntity): QrCode {
        return QrCode(
            id = qrCodeEntity.id,
            data = qrCodeEntity.data,
            animal = qrCodeEntity.animal?.let { animalConverter.animalEntityToAnimal(it) }
        )
    }

    fun qrCodeToQrCodeEntity(qrCode: QrCode): QrCodeEntity {
        return QrCodeEntity(
            id = qrCode.id,
            data = qrCode.data,
            animal = qrCode.animal?.let { animalConverter.animalToAnimalEntity(it) }
        )
    }

}