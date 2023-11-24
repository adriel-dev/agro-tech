package br.com.agrotech.web.image.exception

import br.com.agrotech.domain.exception.InvalidFileException

open class InvalidImageException : InvalidFileException("Image not valid! Only .jpeg and .png image extensions are supported! The image file size must not exceed 50MB!")