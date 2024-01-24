package br.com.agrotech.web.farm.converter

import br.com.agrotech.domain.farm.model.Farm
import br.com.agrotech.web.farm.dto.FarmDTO
import br.com.agrotech.web.farm.dto.request.SaveFarmRequestDTO
import br.com.agrotech.web.farm.dto.request.SaveFirstFarmRequestDTO
import br.com.agrotech.web.farm.dto.response.SaveFarmResponseDTO
import org.springframework.stereotype.Component

@Component
class FarmWebConverter {

    fun farmDtoToFarm(farmDTO: FarmDTO): Farm {
        return Farm(
            farmDTO.id,
            farmDTO.name,
            farmDTO.address,
            farmDTO.city,
            farmDTO.state
        )
    }

    fun farmToFarmDto(farm: Farm): FarmDTO {
        return FarmDTO(
            farm.id,
            farm.name,
            farm.address,
            farm.city,
            farm.state
        )
    }

    fun saveFarmRequestDtoToFarm(saveFarmRequestDTO: SaveFarmRequestDTO): Farm {
        return Farm(
            name = saveFarmRequestDTO.name,
            address = saveFarmRequestDTO.address,
            city = saveFarmRequestDTO.city,
            state = saveFarmRequestDTO.state
        )
    }

    fun saveFirstFarmRequestDtoToFarm(saveFirstFarmRequestDTO: SaveFirstFarmRequestDTO): Farm {
        return Farm(
            name = saveFirstFarmRequestDTO.name,
            address = saveFirstFarmRequestDTO.address,
            city = saveFirstFarmRequestDTO.city,
            state = saveFirstFarmRequestDTO.state
        )
    }

    fun farmToSaveFarmResponseDto(farm: Farm): SaveFarmResponseDTO {
        return SaveFarmResponseDTO(
            id = farm.id,
            name = farm.name,
            address = farm.address,
            city = farm.city,
            state = farm.state
        )
    }

}