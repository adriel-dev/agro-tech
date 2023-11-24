package br.com.agrotech.web.error

import br.com.agrotech.domain.exception.AlreadyExistsException
import br.com.agrotech.domain.exception.NotFoundException
import br.com.agrotech.web.image.exception.InvalidImageException
import br.com.agrotech.web.security.exception.JwtGenerateException
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.http.HttpStatus.*

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<ErrorResponse> {
        return status(NOT_FOUND).body(ErrorResponse(status = NOT_FOUND.value(), error = ErrorsEnum.NOT_FOUND.toString(), message = e.message))
    }

    @ExceptionHandler(AlreadyExistsException::class)
    fun handleAlreadyExistsException(e: AlreadyExistsException): ResponseEntity<ErrorResponse> {
        return status(BAD_REQUEST).body(ErrorResponse(status = BAD_REQUEST.value(), error = ErrorsEnum.BAD_REQUEST.toString(), message = e.message))
    }

    @ExceptionHandler(JwtGenerateException::class)
    fun handleJwtGenerateException(e: JwtGenerateException): ResponseEntity<ErrorResponse> {
        return status(INTERNAL_SERVER_ERROR).body(ErrorResponse(status = INTERNAL_SERVER_ERROR.value(), error = ErrorsEnum.INTERNAL_SERVER_ERROR.toString(), message = e.message))
    }

    @ExceptionHandler(InvalidImageException::class)
    fun handleInvalidImageException(e: InvalidImageException): ResponseEntity<ErrorResponse> {
        return status(BAD_REQUEST).body(ErrorResponse(status = BAD_REQUEST.value(), error = ErrorsEnum.BAD_REQUEST.toString(), message = e.message))
    }

}