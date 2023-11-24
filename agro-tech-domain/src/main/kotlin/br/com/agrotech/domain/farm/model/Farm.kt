package br.com.agrotech.domain.farm.model

import java.util.*

data class Farm(
    var id: UUID? = null,
    var name: String? = null,
    var address: String? = null,
    var city: String? = null,
    var state: String? = null
)
