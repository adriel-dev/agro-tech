package br.com.agrotech

import br.com.agrotech.web.infra.ImageFileConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableConfigurationProperties(ImageFileConfigurationProperties::class)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
open class AgrotechApplication

fun main(args: Array<String>) {
    runApplication<AgrotechApplication>(*args)
}