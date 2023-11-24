package br.com.agrotech.persistence.image.entity

import br.com.agrotech.persistence.animal.entity.AnimalEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_image")
class ImageEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var type: String? = null,
    var filePath: String? = null,
    var fileExtension: String? = null,
    @OneToOne @JoinColumn(name = "animal_id")
    var animal: AnimalEntity? = null
)