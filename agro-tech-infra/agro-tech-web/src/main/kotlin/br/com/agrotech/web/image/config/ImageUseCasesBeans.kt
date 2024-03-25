package br.com.agrotech.web.image.config

import br.com.agrotech.domain.image.port.api.usecase.FindImageByAnimalId
import br.com.agrotech.domain.image.port.api.usecase.SaveImage
import br.com.agrotech.domain.image.port.api.usecase.impl.FindImageByAnimalIdUseCase
import br.com.agrotech.domain.image.port.spi.SaveImagePort
import br.com.agrotech.domain.image.port.api.usecase.impl.SaveImageUseCase
import br.com.agrotech.domain.image.port.spi.LoadImagePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ImageUseCasesBeans {

    @Bean
    open fun findImageByAnimalId(loadImagePort: LoadImagePort): FindImageByAnimalId = FindImageByAnimalIdUseCase(loadImagePort)

    @Bean
    open fun saveImage(saveImagePort: SaveImagePort): SaveImage {
        return SaveImageUseCase(
            saveImagePort = saveImagePort
        )
    }

}