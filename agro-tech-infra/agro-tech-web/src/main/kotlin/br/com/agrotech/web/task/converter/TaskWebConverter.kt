package br.com.agrotech.web.task.converter

import br.com.agrotech.domain.employee.model.Employee
import br.com.agrotech.domain.task.model.Task
import br.com.agrotech.domain.task.model.TaskStatus
import br.com.agrotech.web.employee.converter.EmployeeWebConverter
import br.com.agrotech.web.task.dto.TaskDTO
import br.com.agrotech.web.task.dto.TaskStatusDTO
import br.com.agrotech.web.task.dto.request.CreateTaskRequestDTO
import org.springframework.stereotype.Component

@Component
class TaskWebConverter(
    private val employeeWebConverter: EmployeeWebConverter
) {

    fun taskToTaskDto(task: Task): TaskDTO {
        return TaskDTO(
            id = task.id,
            title = task.title,
            description = task.description,
            status = task.status?.let { mapTaskStatusToTaskStatusDTO(it) },
            employee = task.employee?.let { employeeWebConverter.employeeToEmployeeDto(it) },
            startDate = task.startDate,
            startedAt = task.startedAt,
            finishUntil = task.finishUntil,
            finishedAt = task.finishedAt,
            createdDate = task.createdDate,
            createdBy = task.createdBy,
            lastModifiedBy = task.lastModifiedBy,
            lastModifiedDate = task.lastModifiedDate,
            isDeleted = task.isDeleted
        )
    }

    fun taskDtoToTask(taskDTO: TaskDTO): Task {
        return Task(
            id = taskDTO.id,
            title = taskDTO.title,
            description = taskDTO.description,
            status = taskDTO.status?.let { mapTaskStatusDTOToTask(it) },
            employee = taskDTO.employee?.let { employeeWebConverter.employeeDtoToEmployee(it) },
            startDate = taskDTO.startDate,
            startedAt = taskDTO.startedAt,
            finishUntil = taskDTO.finishUntil,
            finishedAt = taskDTO.finishedAt,
            createdDate = taskDTO.createdDate,
            createdBy = taskDTO.createdBy,
            lastModifiedBy = taskDTO.lastModifiedBy,
            lastModifiedDate = taskDTO.lastModifiedDate,
            isDeleted = taskDTO.isDeleted
        )
    }

    fun createTaskRequestDtoToTask(createTaskRequestDTO: CreateTaskRequestDTO): Task {
        return Task(
            title = createTaskRequestDTO.title,
            description = createTaskRequestDTO.description,
            employee = Employee(id = createTaskRequestDTO.employeeId),
            startDate = createTaskRequestDTO.startDate,
            finishUntil = createTaskRequestDTO.finishUntil
        )
    }

    private fun mapTaskStatusToTaskStatusDTO(taskStatus: TaskStatus): TaskStatusDTO {
        return when (taskStatus) {
            TaskStatus.TO_DO -> TaskStatusDTO.TO_DO
            TaskStatus.DOING -> TaskStatusDTO.DOING
            TaskStatus.DONE -> TaskStatusDTO.DONE
        }
    }

    private fun mapTaskStatusDTOToTask(taskStatusDTO: TaskStatusDTO): TaskStatus {
        return when (taskStatusDTO) {
            TaskStatusDTO.TO_DO -> TaskStatus.TO_DO
            TaskStatusDTO.DOING -> TaskStatus.DOING
            TaskStatusDTO.DONE -> TaskStatus.DONE
        }
    }

}