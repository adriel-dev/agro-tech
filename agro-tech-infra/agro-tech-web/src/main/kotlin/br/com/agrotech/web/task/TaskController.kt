package br.com.agrotech.web.task

import br.com.agrotech.domain.pagination.DomainPage
import br.com.agrotech.domain.task.port.api.usecase.*
import br.com.agrotech.web.task.converter.TaskWebConverter
import br.com.agrotech.web.task.dto.TaskDTO
import br.com.agrotech.web.task.dto.request.CreateTaskRequestDTO
import br.com.agrotech.web.task.dto.request.UpdateTaskRequestDTO
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*


@RestController
@RequestMapping("/api/v1/task")
class TaskController(
    private val findAllTasksByStartDate: FindAllTasksByStartDate,
    private val createTask: CreateTask,
    private val updateTask: UpdateTask,
    private val markTaskAsDoing: MarkTaskAsDoing,
    private val markTaskAsDone: MarkTaskAsDone,
    private val deleteTaskById: DeleteTaskById,
    private val taskConverter: TaskWebConverter
) {

    @GetMapping("/all")
    fun findAllByDate(
        @RequestParam(defaultValue = "0") @PositiveOrZero page: Int,
        @RequestParam(defaultValue = "10") @Positive @Max(100) size: Int,
        @RequestParam(required = true) employeeId: String,
        @RequestParam(required = true) startDate: LocalDate
    ): ResponseEntity<DomainPage<TaskDTO>> {
        val domainPagedTasks = findAllTasksByStartDate.find(page, size, UUID.fromString(employeeId), startDate)
        val tasksContent = domainPagedTasks.content.map { taskConverter.taskToTaskDto(it) }
        val tasksPage = DomainPage(tasksContent, domainPagedTasks.totalPages, domainPagedTasks.totalElements, domainPagedTasks.pageSize, domainPagedTasks.pageNumber)
        return ok().body(tasksPage)
    }

    @PostMapping("/save")
    fun createTask(@RequestBody createTaskRequestDTO: CreateTaskRequestDTO): ResponseEntity<TaskDTO> {
        val taskToCreate = taskConverter.createTaskRequestDtoToTask(createTaskRequestDTO)
        val createdTask = createTask.create((taskToCreate))
        return status(HttpStatus.CREATED).body(taskConverter.taskToTaskDto(createdTask))
    }

    @PutMapping("/update/{taskId}")
    fun updateTask(@PathVariable taskId: String, @RequestBody updateTaskRequestDTO: UpdateTaskRequestDTO): ResponseEntity<TaskDTO> {
        val updatedTask = updateTask.update(UUID.fromString(taskId), taskConverter.updateTaskRequestDtoToTask(updateTaskRequestDTO))
        return ok().body(taskConverter.taskToTaskDto(updatedTask))
    }

    @PatchMapping("/status/doing/{taskId}")
    fun markTaskAsDoing(@PathVariable taskId: String): ResponseEntity<TaskDTO> {
        val taskDTO = taskConverter.taskToTaskDto(markTaskAsDoing.doMark(UUID.fromString(taskId)))
        return ok().body(taskDTO)
    }

    @PatchMapping("/status/done/{taskId}")
    fun markTaskAsDone(@PathVariable taskId: String): ResponseEntity<TaskDTO> {
        val taskDTO = taskConverter.taskToTaskDto(markTaskAsDone.doMark(UUID.fromString(taskId)))
        return ok().body(taskDTO)
    }

    @DeleteMapping("/delete/{taskId}")
    fun deleteTaskById(@PathVariable taskId: String): ResponseEntity<Void> {
        deleteTaskById.delete(UUID.fromString(taskId))
        return noContent().build()
    }

}