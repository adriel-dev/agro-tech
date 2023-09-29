package br.com.agrotech.domain.owner.port.api.usecase

import java.util.*

interface DeleteOwnerById {
    fun delete(ownerId: UUID)
}