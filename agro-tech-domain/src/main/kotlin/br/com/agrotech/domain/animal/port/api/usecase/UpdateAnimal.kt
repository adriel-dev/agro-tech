package br.com.agrotech.domain.animal.port.api.usecase

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.image.model.Image
import java.util.UUID

interface UpdateAnimal {
    fun update(animalId: UUID, animal: Animal, imageBytes: ByteArray?, image: Image?): Animal
}