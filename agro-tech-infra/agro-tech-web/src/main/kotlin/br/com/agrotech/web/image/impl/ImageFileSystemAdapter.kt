package br.com.agrotech.web.image.impl

import br.com.agrotech.domain.image.model.Image
import br.com.agrotech.domain.image.port.spi.LoadImagePort
import br.com.agrotech.domain.image.port.spi.SaveImagePort
import br.com.agrotech.persistence.image.converter.ImagePersistenceConverter
import br.com.agrotech.persistence.image.exception.ImageNotFoundException
import br.com.agrotech.persistence.image.repository.ImageJpaRepository
import br.com.agrotech.web.infra.ImageFileConfigurationProperties
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

class ImageFileSystemAdapter(
    private val imageConfigProperties: ImageFileConfigurationProperties,
    private val imageJpaRepository: ImageJpaRepository,
    private val imageConverter: ImagePersistenceConverter
) : SaveImagePort, LoadImagePort {

    private val DIRECTORY_PATH: String = imageConfigProperties.directoryPath

    override fun load(key: String): ByteArray {
        val animalId = UUID.fromString(key)
        val foundImage = imageJpaRepository.findByAnimalId(animalId).orElseThrow { ImageNotFoundException(animalId) }
        val directory = File(foundImage.filePath!!)
        val inputStream = FileInputStream(directory)
        val fileSize = directory.length().toInt()
        val bytes = ByteArray(fileSize)

        inputStream.use {
            it.read(bytes)
        }

        return bytes
    }

    override fun save(image: Image, imageData: ByteArray) {
        val animalId = image.animal?.id
        val directory = File("$DIRECTORY_PATH/$animalId")
        if(!directory.exists()){
            val mkdir = directory.mkdirs()
            if(!mkdir) throw RuntimeException("Failed to create image directory!")
        }
        val fileName = "animal-$animalId-picture.${image.fileExtension}"
        val file = File(directory, fileName)
        val outputStream = FileOutputStream(file)

        outputStream.use {
            it.write(imageData)
        }

        image.filePath = "$DIRECTORY_PATH/$animalId/$fileName"
        imageJpaRepository.save(imageConverter.imageToImageEntity(image))
    }

}