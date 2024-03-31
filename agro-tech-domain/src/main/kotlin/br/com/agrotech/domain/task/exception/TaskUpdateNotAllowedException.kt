package br.com.agrotech.domain.task.exception

import br.com.agrotech.domain.exception.AgroTechException

class TaskUpdateNotAllowedException(message: String) : AgroTechException(message)