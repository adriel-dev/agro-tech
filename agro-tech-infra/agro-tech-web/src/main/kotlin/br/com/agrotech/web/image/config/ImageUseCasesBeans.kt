package br.com.agrotech.web.image.config

import br.com.agrotech.domain.image.port.api.usecase.SaveImage
import br.com.agrotech.domain.image.port.spi.SaveImagePort
import br.com.agrotech.domain.image.port.api.usecase.impl.SaveImageUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ImageUseCasesBeans {

    @Bean
    open fun saveImage(saveImagePort: SaveImagePort): SaveImage {
        return SaveImageUseCase(
            saveImagePort = saveImagePort
        )
    }

}