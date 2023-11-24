package br.com.agrotech.domain.animal.port.api.usecase

import br.com.agrotech.domain.animal.model.Animal
import br.com.agrotech.domain.image.model.Image


interface SaveAnimal {
    fun save(animal: Animal, image: Image?, imageData: ByteArray?): Animal
}