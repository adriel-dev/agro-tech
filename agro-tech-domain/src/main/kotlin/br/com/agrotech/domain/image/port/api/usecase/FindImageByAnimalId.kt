package br.com.agrotech.domain.image.port.api.usecase

import java.util.*

interface FindImageByAnimalId {
    fun find(animalId: UUID): ByteArray
}