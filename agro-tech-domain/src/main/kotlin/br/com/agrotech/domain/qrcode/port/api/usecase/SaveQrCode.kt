package br.com.agrotech.domain.qrcode.port.api.usecase

import br.com.agrotech.domain.qrcode.model.QrCode

interface SaveQrCode {
    fun save(qrCode: QrCode)
}