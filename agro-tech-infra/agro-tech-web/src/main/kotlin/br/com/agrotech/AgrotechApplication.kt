package br.com.agrotech

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AgrotechApplication

fun main(args: Array<String>) {
    runApplication<AgrotechApplication>(*args)
}