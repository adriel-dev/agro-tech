package br.com.agrotech.web.user.config

import br.com.agrotech.domain.user.port.api.usecase.FindRoleByName
import br.com.agrotech.domain.user.port.api.usecase.impl.FindRoleByNameUseCase
import br.com.agrotech.domain.user.port.spi.persistence.RoleRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class RoleUseCasesBeans {

    @Bean
    open fun findRoleByName(roleRepository: RoleRepository): FindRoleByName {
        return FindRoleByNameUseCase(roleRepository)
    }

}