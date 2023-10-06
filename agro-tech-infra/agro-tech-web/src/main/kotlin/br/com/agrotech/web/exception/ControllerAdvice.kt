package br.com.agrotech.web.exception

import br.com.agrotech.domain.exception.AlreadyExistsException
import br.com.agrotech.domain.exception.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.http.HttpStatus.*
import java.time.Instant
import java.time.temporal.ChronoUnit

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<ErrorResponse> {
        return status(NOT_FOUND).body(ErrorResponse(NOT_FOUND.value(), "Not Found", e.message))
    }

    @ExceptionHandler(AlreadyExistsException::class)
    fun handleAlreadyExistsException(e: AlreadyExistsException): ResponseEntity<ErrorResponse> {
        return status(BAD_REQUEST).body(ErrorResponse(BAD_REQUEST.value(), "Bad Request", e.message))
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<ErrorResponse> {
        return status(INTERNAL_SERVER_ERROR).body(ErrorResponse(INTERNAL_SERVER_ERROR.value(), "Internal Server Error", e.message))
    }

}

class ErrorResponse(
    var status: Int? = null,
    var error: String? = null,
    var message: String? = null,
    var timestamp: Instant? = Instant.now().truncatedTo(ChronoUnit.SECONDS)
)