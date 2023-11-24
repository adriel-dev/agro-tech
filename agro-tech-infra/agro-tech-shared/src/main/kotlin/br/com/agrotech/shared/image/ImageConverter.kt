package br.com.agrotech.shared.image

import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.persistence.image.entity.ImageEntity
import br.com.agrotech.web.image.dto.ImageDTO

interface ImageConverter {
    fun imageEntityToImage(imageEntity: ImageEntity): Image
    fun imageToImageEntity(image: Image): ImageEntity
    fun imageDtoToImage(imageDTO: ImageDTO): Image
    fun imageToImageDto(image: Image): ImageDTO
}