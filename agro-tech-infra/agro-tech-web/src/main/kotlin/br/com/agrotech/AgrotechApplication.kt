package br.com.agrotech

import br.com.agrotech.web.infra.ImageFileConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ImageFileConfigurationProperties::class)
open class AgrotechApplication

fun main(args: Array<String>) {
    runApplication<AgrotechApplication>(*args)
}