package br.com.agrotech.domain.image.port.spi

import br.com.agrotech.domain.image.model.Image

interface SaveImagePort {
    fun save(image: Image, imageData: ByteArray)
}