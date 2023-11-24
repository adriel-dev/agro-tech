package br.com.agrotech.web.animal.impl

import br.com.agrotech.domain.animal.port.api.usecase.FindAnimalById
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import br.com.agrotech.domain.image.port.spi.LoadImagePort
import br.com.agrotech.domain.qrcode.port.spi.LoadQrCodePort
import br.com.agrotech.persistence.image.exception.ImageNotFoundException
import br.com.agrotech.persistence.qrcode.exception.QrCodeNotFoundException
import br.com.agrotech.shared.image.ImageConverter
import br.com.agrotech.shared.qrcode.QrCodeConverter
import org.springframework.transaction.annotation.Transactional
import java.util.*

open class FindAnimalByIdUseCase(
    private val animalRepository: AnimalRepository,
    private val loadImagePort: LoadImagePort,
    private val loadQrCodePort: LoadQrCodePort,
    private val imageConverter: ImageConverter,
    private val qrCodeConverter: QrCodeConverter
) : FindAnimalById {

    @Transactional
    override fun find(animalId: UUID): Map<String, Any> {
        val foundAnimal = animalRepository.findAnimalById(animalId)
        val result: MutableMap<String, Any> = mutableMapOf("animal" to foundAnimal)

        try {
            val imageData = loadImagePort.load(key = animalId.toString())
            result["imageData"] = imageData
        } catch (e: ImageNotFoundException) {
            // Lidar com a exceção, se necessário
        }

        try {
            val foundQrCode = loadQrCodePort.load(animalId.toString())
            result["qrCode"] = qrCodeConverter.qrCodeToQrCodeDto(foundQrCode)
        } catch (e: QrCodeNotFoundException) {
            // Lidar com a exceção, se necessário
        }

        return result
    }

}