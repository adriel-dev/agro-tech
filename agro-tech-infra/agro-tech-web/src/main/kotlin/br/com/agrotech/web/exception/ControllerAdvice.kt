package br.com.agrotech.web.exception

import br.com.agrotech.domain.exception.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.http.HttpStatus.*

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<ErrorMessageModel> {
        return status(NOT_FOUND).body(ErrorMessageModel(NOT_FOUND.value(), e.message))
    }

}

class ErrorMessageModel(
    var status: Int? = null,
    var message: String? = null
)