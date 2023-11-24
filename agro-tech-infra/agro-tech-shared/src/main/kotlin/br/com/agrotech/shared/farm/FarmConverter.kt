package br.com.agrotech.shared.farm

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.persistence.farm.entity.FarmEntity
import br.com.agrotech.web.farm.dto.FarmDTO
import br.com.agrotech.web.farm.dto.request.SaveFarmRequestDTO
import br.com.agrotech.web.farm.dto.request.SaveFirstFarmRequestDTO
import br.com.agrotech.web.farm.dto.response.SaveFarmResponseDTO

interface FarmConverter {
    fun farmEntityToFarm(farmEntity: FarmEntity): Farm
    fun farmToFarmEntity(farm: Farm): FarmEntity
    fun farmDtoToFarm(farmDTO: FarmDTO): Farm
    fun farmToFarmDto(farm: Farm): FarmDTO
    fun saveFarmRequestDtoToFarm(saveFarmRequestDTO: SaveFarmRequestDTO): Farm
    fun saveFirstFarmRequestDtoToFarm(saveFirstFarmRequestDTO: SaveFirstFarmRequestDTO): Farm
    fun farmToSaveFarmResponseDto(farm: Farm): SaveFarmResponseDTO
}