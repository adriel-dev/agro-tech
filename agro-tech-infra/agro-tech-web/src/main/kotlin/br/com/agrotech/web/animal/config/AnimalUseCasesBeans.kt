package br.com.agrotech.web.animal.config

import br.com.agrotech.domain.animal.port.api.usecase.DeleteAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.FindAnimalById
import br.com.agrotech.domain.animal.port.api.usecase.SaveAnimal
import br.com.agrotech.domain.animal.port.api.usecase.UpdateAnimal
import br.com.agrotech.domain.animal.port.api.usecase.impl.DeleteAnimalByIdUseCase
import br.com.agrotech.domain.animal.port.api.usecase.impl.FindAnimalByIdUseCase
import br.com.agrotech.domain.animal.port.api.usecase.impl.SaveAnimalUseCase
import br.com.agrotech.domain.animal.port.api.usecase.impl.UpdateAnimalUseCase
import br.com.agrotech.domain.animal.port.spi.persistence.AnimalRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AnimalUseCasesBeans {

    @Bean
    open fun saveAnimal(animalRepository: AnimalRepository): SaveAnimal {
        return SaveAnimalUseCase(animalRepository)
    }

    @Bean
    open fun findAnimalById(animalRepository: AnimalRepository): FindAnimalById {
        return FindAnimalByIdUseCase(animalRepository)
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