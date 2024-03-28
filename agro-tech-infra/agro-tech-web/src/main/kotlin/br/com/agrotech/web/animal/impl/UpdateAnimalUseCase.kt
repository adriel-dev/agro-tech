package br.com.agrotech.web.animal.impl

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.animal.port.api.usecase.UpdateAnimal
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.domain.image.port.api.usecase.SaveImage
import br.com.agrotech.domain.image.port.spi.LoadImagePort
import br.com.agrotech.domain.image.port.spi.SaveImagePort
import br.com.agrotech.persistence.image.converter.ImagePersistenceConverter
import br.com.agrotech.persistence.image.repository.ImageJpaRepository
import jakarta.transaction.Transactional
import java.util.*

open class UpdateAnimalUseCase(
    private val animalRepository: AnimalRepository,
    private val imageJpaRepository: ImageJpaRepository,
    private val saveImagePort: SaveImagePort,
    private val imagePersistenceConverter: ImagePersistenceConverter
) : UpdateAnimal {

    @Transactional
    override fun update(animalId: UUID, animal: Animal, imageBytes: ByteArray?, image: Image?): Animal {
        val savedAnimal = animalRepository.updateAnimal(animalId, animal)
        imageBytes?.let { imageByteArray ->
            imageJpaRepository.findByAnimalId(animalId).ifPresentOrElse(
                {
                    val imageToSave = imagePersistenceConverter.imageEntityToImage(it);
                    image?.let {parImage ->
                        imageToSave.fileExtension = parImage.fileExtension
                        imageToSave.type = parImage.type
                    }
                    saveImagePort.save(imageToSave, imageByteArray)
                },
                {
                    saveImagePort.save(image!!, imageBytes)
                }
            )
        }
        return savedAnimal
    }

}