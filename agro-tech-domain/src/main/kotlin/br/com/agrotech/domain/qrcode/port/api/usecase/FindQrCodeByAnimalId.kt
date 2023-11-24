package br.com.agrotech.domain.qrcode.port.api.usecase

import br.com.agrotech.domain.qrcode.model.QrCode
import java.util.UUID

interface FindQrCodeByAnimalId {
    fun find(animalId: UUID): QrCode
}