package br.com.agrotech.domain.qrcode.port.api.usecase.impl

import br.com.agrotech.domain.qrcode.model.QrCode
import br.com.agrotech.domain.qrcode.port.api.usecase.FindQrCodeByAnimalId
import br.com.agrotech.domain.qrcode.port.spi.LoadQrCodePort
import java.util.*

class FindQrCodeByAnimalIdUseCase(
    private val loadQrCodePort: LoadQrCodePort
) : FindQrCodeByAnimalId {

    override fun find(animalId: UUID): QrCode {
        return loadQrCodePort.load(animalId.toString())
    }

}