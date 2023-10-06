package br.com.agrotech.web.security.user

import br.com.agrotech.domain.user.port.api.usecase.RegisterUser
import br.com.agrotech.domain.user.port.api.usecase.impl.RegisterUserUseCase
import br.com.agrotech.domain.user.port.spi.persistence.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class UserUseCasesBeans {

    @Bean
    open fun registerUser(userRepository: UserRepository): RegisterUser {
        return RegisterUserUseCase(userRepository)
    }

}