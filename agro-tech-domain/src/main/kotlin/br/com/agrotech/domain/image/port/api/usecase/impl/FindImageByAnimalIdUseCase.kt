package br.com.agrotech.domain.image.port.api.usecase.impl

import br.com.agrotech.domain.image.port.api.usecase.FindImageByAnimalId
import br.com.agrotech.domain.image.port.spi.LoadImagePort
import java.util.*

class FindImageByAnimalIdUseCase(
    private val loadImagePort: LoadImagePort
) : FindImageByAnimalId {

    override fun find(animalId: UUID): ByteArray {
        return loadImagePort.load(animalId.toString())
    }

}