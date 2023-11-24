package br.com.agrotech.domain.qrcode.port.spi

import br.com.agrotech.domain.qrcode.model.QrCode

interface LoadQrCodePort {
    fun load(key: String): QrCode
}