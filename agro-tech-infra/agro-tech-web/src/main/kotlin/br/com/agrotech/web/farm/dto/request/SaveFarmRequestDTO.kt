package br.com.agrotech.web.farm.dto.request

data class SaveFarmRequestDTO(
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val ownerId: String? = null
)

data class SaveFirstFarmRequestDTO(
    val name: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
)