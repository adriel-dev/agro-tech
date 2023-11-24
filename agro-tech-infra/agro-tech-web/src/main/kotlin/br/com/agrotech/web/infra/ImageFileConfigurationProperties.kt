package br.com.agrotech.web.infra

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "agrotech.image")
class ImageFileConfigurationProperties(
    val directoryPath: String
)