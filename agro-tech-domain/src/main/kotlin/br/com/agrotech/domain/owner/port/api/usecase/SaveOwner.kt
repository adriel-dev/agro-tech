package br.com.agrotech.domain.owner.port.api.usecase

import br.com.agrotech.domain.owner.model.Owner

interface SaveOwner {
    fun save(owner: Owner): Owner
}