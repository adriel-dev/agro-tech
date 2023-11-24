package br.com.agrotech.domain.image.port.api.usecase.impl

import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.domain.image.port.api.usecase.SaveImage
import br.com.agrotech.domain.image.port.spi.SaveImagePort

class SaveImageUseCase(
    private val saveImagePort: SaveImagePort
) : SaveImage {

    override fun save(image: Image, imageData: ByteArray) {
        saveImagePort.save(image = image, imageData = imageData)
    }

}