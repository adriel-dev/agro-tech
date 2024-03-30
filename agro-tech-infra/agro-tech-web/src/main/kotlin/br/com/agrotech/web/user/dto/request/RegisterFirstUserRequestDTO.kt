package br.com.agrotech.web.user.dto.request

import br.com.agrotech.web.farm.dto.request.SaveFirstFarmRequestDTO

data class RegisterFirstUserRequestDTO(
    val userData: RegisterFirstUserDataRequestDTO? = null,
    val farmData: SaveFirstFarmRequestDTO? = null
)

data class RegisterFirstUserDataRequestDTO(
    val username: String? = null,
    val password: String? = null,
    val email: String? = null
)