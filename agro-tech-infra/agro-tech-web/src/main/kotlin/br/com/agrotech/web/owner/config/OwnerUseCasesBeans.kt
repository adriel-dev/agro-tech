package br.com.agrotech.web.owner.config

import br.com.agrotech.domain.owner.port.api.usecase.DeleteOwnerById
import br.com.agrotech.domain.owner.port.api.usecase.FindOwnerById
import br.com.agrotech.domain.owner.port.api.usecase.SaveOwner
import br.com.agrotech.domain.owner.port.api.usecase.UpdateOwner
import br.com.agrotech.domain.owner.port.api.usecase.impl.DeleteOwnerByIdUseCase
import br.com.agrotech.domain.owner.port.api.usecase.impl.FindOwnerByIdUseCase
import br.com.agrotech.domain.owner.port.api.usecase.impl.SaveOwnerUseCase
import br.com.agrotech.domain.owner.port.api.usecase.impl.UpdateOwnerUseCase
import br.com.agrotech.domain.owner.port.spi.persistence.OwnerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class OwnerUseCasesBeans {

    @Bean
    open fun saveOwner(ownerRepository: OwnerRepository): SaveOwner {
        return SaveOwnerUseCase(ownerRepository)
    }

    @Bean
    open fun findOwnerById(ownerRepository: OwnerRepository): FindOwnerById {
        return FindOwnerByIdUseCase(ownerRepository)
    }

    @Bean
    open fun updateOwner(ownerRepository: OwnerRepository): UpdateOwner {
        return UpdateOwnerUseCase(ownerRepository)
    }

    @Bean
    open fun deleteOwnerById(ownerRepository: OwnerRepository): DeleteOwnerById {
        return DeleteOwnerByIdUseCase(ownerRepository)
    }

}