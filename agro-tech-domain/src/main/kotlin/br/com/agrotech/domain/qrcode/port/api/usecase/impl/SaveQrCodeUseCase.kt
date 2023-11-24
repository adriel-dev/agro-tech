package br.com.agrotech.domain.qrcode.port.api.usecase.impl

import br.com.agrotech.domain.qrcode.model.QrCode
import br.com.agrotech.domain.qrcode.port.api.usecase.SaveQrCode
import br.com.agrotech.domain.qrcode.port.spi.SaveQrCodePort

class SaveQrCodeUseCase(
    private val saveQrCodePort: SaveQrCodePort
) : SaveQrCode {

    override fun save(qrCode: QrCode) {
        saveQrCodePort.save(qrCode)
    }

}