package br.com.agrotech.persistence.qrcode.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.*

class QrCodeNotFoundException(animalId: UUID) : NotFoundException("QrCode with AnimalID [${animalId}] was not found!")