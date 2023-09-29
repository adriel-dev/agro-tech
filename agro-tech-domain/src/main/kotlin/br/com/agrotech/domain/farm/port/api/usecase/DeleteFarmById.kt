package br.com.agrotech.domain.farm.port.api.usecase

import java.util.*

interface DeleteFarmById {
    fun delete(farmId: UUID)
}