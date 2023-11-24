package br.com.agrotech.web.farm.dto

import java.util.*

data class FarmDTO(
    val id: UUID? = null,
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null
)