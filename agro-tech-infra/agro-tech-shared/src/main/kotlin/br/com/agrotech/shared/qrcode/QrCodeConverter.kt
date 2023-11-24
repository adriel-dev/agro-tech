package br.com.agrotech.shared.qrcode

import br.com.agrotech.domain.qrcode.model.QrCode
import br.com.agrotech.persistence.qrcode.entity.QrCodeEntity
import br.com.agrotech.web.qrcode.dto.QrCodeDTO

interface QrCodeConverter {
    fun qrCodeEntityToQrCode(qrCodeEntity: QrCodeEntity): QrCode
    fun qrCodeToQrCodeEntity(qrCode: QrCode): QrCodeEntity
    fun qrCodeDtoToQrCode(qrCodeDTO: QrCodeDTO): QrCode
    fun qrCodeToQrCodeDto(qrCode: QrCode): QrCodeDTO
}