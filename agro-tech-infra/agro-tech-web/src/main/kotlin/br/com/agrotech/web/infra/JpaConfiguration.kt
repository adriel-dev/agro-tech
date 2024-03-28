package br.com.agrotech.web.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware

@Configuration
open class JpaConfiguration {

    @Bean
    open fun auditorAware(): AuditorAware<String> {
        return CustomAuditorAware()
    }

}