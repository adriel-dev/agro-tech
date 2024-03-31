package br.com.agrotech.web.task.config

import br.com.agrotech.domain.task.port.api.usecase.*
import br.com.agrotech.domain.task.port.api.usecase.impl.*
import br.com.agrotech.domain.task.port.spi.persistence.TaskRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class TaskUseCasesBeans {

    @Bean
    open fun findAllByStartDate(taskRepository: TaskRepository): FindAllTasksByStartDate = FindAllTasksByStartDateUseCase(taskRepository)

    @Bean
    open fun createTask(taskRepository: TaskRepository): CreateTask = CreateTaskUseCase(taskRepository)

    @Bean
    open fun updateTask(taskRepository: TaskRepository): UpdateTask = UpdateTaskUseCase(taskRepository)

    @Bean
    open fun markTaskAsDoing(taskRepository: TaskRepository): MarkTaskAsDoing = MarkTaskAsDoingUseCase(taskRepository)

    @Bean
    open fun markTaskAsDone(taskRepository: TaskRepository): MarkTaskAsDone = MarkTaskAsDoneUseCase(taskRepository)

    @Bean
    open fun deleteTaskById(taskRepository: TaskRepository): DeleteTaskById = DeleteTaskByIdUseCase(taskRepository)

}