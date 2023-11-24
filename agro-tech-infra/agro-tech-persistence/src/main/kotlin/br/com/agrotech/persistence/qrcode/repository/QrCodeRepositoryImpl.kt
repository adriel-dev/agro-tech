package br.com.agrotech.persistence.qrcode.repository

import br.com.agrotech.domain.qrcode.model.QrCode
import br.com.agrotech.domain.qrcode.port.spi.LoadQrCodePort
import br.com.agrotech.domain.qrcode.port.spi.SaveQrCodePort
import br.com.agrotech.persistence.qrcode.exception.QrCodeNotFoundException
import br.com.agrotech.shared.qrcode.QrCodeConverter
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class QrCodeRepositoryImpl(
    private val qrCodeJpaRepository: QrCodeJpaRepository,
    private val qrCodeConverter: QrCodeConverter
) : SaveQrCodePort, LoadQrCodePort {

    override fun load(key: String): QrCode {
        val animalId = UUID.fromString(key)
        val foundQrCode = qrCodeJpaRepository.findByAnimalId(animalId).orElseThrow { QrCodeNotFoundException(animalId) }
        return qrCodeConverter.qrCodeEntityToQrCode(foundQrCode)
    }

    override fun save(qrCode: QrCode) {
        qrCodeJpaRepository.save(qrCodeConverter.qrCodeToQrCodeEntity(qrCode))
    }

}