package br.com.agrotech.domain.task.exception

import br.com.agrotech.domain.exception.AgroTechException
import java.time.LocalDateTime

class InvalidStartDateException(startDate: LocalDateTime, finishUntil: LocalDateTime) : AgroTechException("The 'startDate'($startDate) must be before 'finishUntil'($finishUntil) date! ") {
}