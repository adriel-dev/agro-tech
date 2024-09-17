package br.com.agrotech.persistence.task.exception

import br.com.agrotech.domain.exception.NotFoundException
import java.util.UUID

class TaskNotFoundException(taskId: UUID) : NotFoundException("Task with ID [${taskId}] was not found!")