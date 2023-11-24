package br.com.agrotech.web.animal.config

import br.com.agrotech.domain.animal.port.api.usecase.DeleteAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.FindAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.SaveAnimal
import br.com.agrotech.domain.animal.port.api.usecase.UpdateAnimal
import br.com.agrotech.domain.animal.port.api.usecase.impl.DeleteAnimalByIdUseCase
import br.com.agrotech.domain.animal.port.api.usecase.impl.UpdateAnimalUseCase
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import br.com.agrotech.domain.image.port.api.usecase.SaveImage
import br.com.agrotech.domain.image.port.spi.LoadImagePort
import br.com.agrotech.domain.qrcode.port.spi.LoadQrCodePort
import br.com.agrotech.shared.image.ImageConverter
import br.com.agrotech.shared.qrcode.QrCodeConverter
import br.com.agrotech.web.animal.impl.FindAnimalByIdUseCase
import br.com.agrotech.web.animal.impl.SaveAnimalUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AnimalUseCasesBeans {

    @Bean
    open fun saveAnimal(animalRepository: AnimalRepository, saveImage: SaveImage): SaveAnimal {
        return SaveAnimalUseCase(animalRepository, saveImage)
    }

    @Bean
    open fun findAnimalById(animalRepository: AnimalRepository, loadImagePort: LoadImagePort, loadQrCodePort: LoadQrCodePort,
                            imageConverter: ImageConverter, qrCodeConverter: QrCodeConverter): FindAnimalById {
        return FindAnimalByIdUseCase(
            animalRepository = animalRepository,
            loadImagePort = loadImagePort,
            loadQrCodePort = loadQrCodePort,
            imageConverter = imageConverter,
            qrCodeConverter = qrCodeConverter
        )
    }

    @Bean
    open fun updateAnimal(animalRepository: AnimalRepository): UpdateAnimal {
        return UpdateAnimalUseCase(animalRepository)
    }

    @Bean
    open fun deleteAnimalById(animalRepository: AnimalRepository): DeleteAnimalById {
        return DeleteAnimalByIdUseCase(animalRepository)
    }

}