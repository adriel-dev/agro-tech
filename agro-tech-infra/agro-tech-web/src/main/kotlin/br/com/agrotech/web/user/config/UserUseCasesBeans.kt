package br.com.agrotech.web.user.config

import br.com.agrotech.domain.farm.port.spi.persistence.FarmRepository
import br.com.agrotech.domain.user.port.api.usecase.RegisterFirstUser
import br.com.agrotech.domain.user.port.api.usecase.RegisterUser
import br.com.agrotech.domain.user.port.api.usecase.impl.RegisterUserUseCase
import br.com.agrotech.domain.user.port.spi.persistence.UserRepository
import br.com.agrotech.web.user.impl.RegisterFirstUserUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class UserUseCasesBeans {

    @Bean
    open fun registerUser(userRepository: UserRepository): RegisterUser {
        return RegisterUserUseCase(userRepository)
    }

    @Bean
    open fun registerFirstUser(userRepository: UserRepository,farmRepository: FarmRepository): RegisterFirstUser {
        return RegisterFirstUserUseCase(userRepository, farmRepository)
    }

}