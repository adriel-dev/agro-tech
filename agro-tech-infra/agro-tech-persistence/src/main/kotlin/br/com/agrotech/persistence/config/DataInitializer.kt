package br.com.agrotech.persistence.config

import br.com.agrotech.domain.breed.port.spi.persistence.BreedRepository
import br.com.agrotech.persistence.animal.repository.AnimalJpaRepository
import br.com.agrotech.persistence.breed.entity.BreedEntity
import br.com.agrotech.persistence.breed.repository.BreedJpaRepository
import br.com.agrotech.persistence.farm.entity.FarmEntity
import br.com.agrotech.persistence.farm.repository.FarmJpaRepository
import br.com.agrotech.persistence.owner.entity.OwnerEntity
import br.com.agrotech.persistence.owner.repository.OwnerJpaRepository
import br.com.agrotech.persistence.species.entity.SpeciesEntity
import br.com.agrotech.persistence.species.repository.SpeciesJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class DataInitializer @Autowired constructor(
    private val breedRepository: BreedJpaRepository,
    private val farmRepository: FarmJpaRepository,
    private val ownerRepository: OwnerJpaRepository,
    private val speciesRepository: SpeciesJpaRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("saving owner...")
        val savedOwner = ownerRepository.save(OwnerEntity(name = "Proprietario", lastName = "Teste", birthDate = LocalDate.of(2000, 2, 20)))
        println("saving farm...")
        farmRepository.save(FarmEntity(name = "Fazenda Teste", address = "Rua Teste", city = "Cajá", state = "Paraiba", owner = savedOwner))
        println("saving species...")
        val savedSpecies = speciesRepository.save(SpeciesEntity(name = "Especie Teste"))
        println("saving breed...")
        breedRepository.save(BreedEntity(name = "Raca teste", species = savedSpecies))
    }
}
