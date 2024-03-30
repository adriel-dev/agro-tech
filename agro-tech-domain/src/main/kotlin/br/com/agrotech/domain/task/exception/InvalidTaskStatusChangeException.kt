package br.com.agrotech.domain.task.exception

import br.com.agrotech.domain.exception.AgroTechException

class InvalidTaskStatusChangeException(message: String) : AgroTechException(message) {
}