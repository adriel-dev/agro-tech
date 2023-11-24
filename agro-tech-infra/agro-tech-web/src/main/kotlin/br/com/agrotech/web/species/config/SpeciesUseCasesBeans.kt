package br.com.agrotech.web.species.config

import br.com.agrotech.domain.species.port.api.usecase.*
import br.com.agrotech.domain.species.port.api.usecase.impl.*
import br.com.agrotech.domain.species.port.spi.persistence.SpeciesRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SpeciesUseCasesBeans {

    @Bean
    open fun saveSpecies(speciesRepository: SpeciesRepository): SaveSpecies {
        return SaveSpeciesUseCase(speciesRepository)
    }

    @Bean
    open fun findSpeciesById(speciesRepository: SpeciesRepository): FindSpeciesById {
        return FindSpeciesByIdUseCase(speciesRepository)
    }

    @Bean
    open fun findAllSpecies(speciesRepository: SpeciesRepository): FindAllSpecies {
        return FindAllSpeciesUseCase(speciesRepository)
    }

    @Bean
    open fun updateSpecies(speciesRepository: SpeciesRepository): UpdateSpecies {
        return UpdateSpeciesUseCase(speciesRepository)
    }

    @Bean
    open fun deleteSpeciesById(speciesRepository: SpeciesRepository): DeleteSpeciesById {
        return DeleteSpeciesByIdUseCase(speciesRepository)
    }

}