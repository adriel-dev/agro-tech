package br.com.agrotech.web.breed.config

import br.com.agrotech.domain.breed.port.api.usecase.*
import br.com.agrotech.domain.breed.port.api.usecase.impl.*
import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class BreedUseCasesBeans {

    @Bean
    open fun saveBreed(breedRepository: BreedRepository): SaveBreed {
        return SaveBreedUseCase(breedRepository)
    }

    @Bean
    open fun findBreedById(breedRepository: BreedRepository): FindBreedById {
        return FindBreedByIdUseCase(breedRepository)
    }

    @Bean
    open fun findAllBreeds(breedRepository: BreedRepository): FindAllBreeds = FindAllBreedsUseCase(breedRepository)

    @Bean
    open fun updateBreed(breedRepository: BreedRepository): UpdateBreed {
        return UpdateBreedUseCase(breedRepository)
    }

    @Bean
    open fun deleteBreedById(breedRepository: BreedRepository): DeleteBreedById {
        return DeleteBreedByIdUseCase(breedRepository)
    }

}