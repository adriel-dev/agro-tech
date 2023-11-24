package br.com.agrotech.web.user.dto.request

import br.com.agrotech.web.farm.dto.request.SaveFirstFarmRequestDTO

data class RegisterFirstUserRequestDTO(
    val userData: RegisterFirstUserDataRequestDTO? = null,
    val farmData: SaveFirstFarmRequestDTO? = null
)