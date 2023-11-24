package br.com.agrotech.web.image.config

import br.com.agrotech.domain.image.port.spi.LoadImagePort
import br.com.agrotech.domain.image.port.spi.SaveImagePort
import br.com.agrotech.persistence.image.repository.ImageJpaRepository
import br.com.agrotech.shared.image.ImageConverter
import br.com.agrotech.web.image.impl.ImageFileSystemAdapter
import br.com.agrotech.web.infra.ImageFileConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ImageAdaptersBeans {

    @Bean
    open fun saveImagePort(imageFileConfigurationProperties: ImageFileConfigurationProperties, imageJpaRepository: ImageJpaRepository, imageConverter: ImageConverter): SaveImagePort {
        return ImageFileSystemAdapter(imageFileConfigurationProperties, imageJpaRepository, imageConverter)
    }

    @Bean
    open fun loadImagePort(imageFileConfigurationProperties: ImageFileConfigurationProperties, imageJpaRepository: ImageJpaRepository, imageConverter: ImageConverter): LoadImagePort {
        return ImageFileSystemAdapter(imageFileConfigurationProperties, imageJpaRepository, imageConverter)
    }

}