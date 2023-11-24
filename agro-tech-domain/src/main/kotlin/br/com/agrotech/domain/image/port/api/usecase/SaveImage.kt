package br.com.agrotech.domain.image.port.api.usecase

import br.com.agrotech.domain.image.model.Image

interface SaveImage {
    fun save(image: Image, imageData: ByteArray)
}