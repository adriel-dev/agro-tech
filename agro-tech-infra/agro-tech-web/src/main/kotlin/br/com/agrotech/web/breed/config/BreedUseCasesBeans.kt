package br.com.agrotech.web.breed.config

import br.com.agrotech.domain.breed.port.api.usecase.DeleteBreedById
import br.com.agrotech.domain.breed.port.api.usecase.FindBreedById
import br.com.agrotech.domain.breed.port.api.usecase.SaveBreed
import br.com.agrotech.domain.breed.port.api.usecase.UpdateBreed
import br.com.agrotech.domain.breed.port.api.usecase.impl.DeleteBreedByIdUseCase
import br.com.agrotech.domain.breed.port.api.usecase.impl.FindBreedByIdUseCase
import br.com.agrotech.domain.breed.port.api.usecase.impl.SaveBreedUseCase
import br.com.agrotech.domain.breed.port.api.usecase.impl.UpdateBreedUseCase
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
    open fun updateBreed(breedRepository: BreedRepository): UpdateBreed {
        return UpdateBreedUseCase(breedRepository)
    }

    @Bean
    open fun deleteBreedById(breedRepository: BreedRepository): DeleteBreedById {
        return DeleteBreedByIdUseCase(breedRepository)
    }

}