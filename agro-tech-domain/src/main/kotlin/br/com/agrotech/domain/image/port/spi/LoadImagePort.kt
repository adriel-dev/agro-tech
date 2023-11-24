package br.com.agrotech.domain.image.port.spi

interface LoadImagePort {
    fun load(key: String): ByteArray
}