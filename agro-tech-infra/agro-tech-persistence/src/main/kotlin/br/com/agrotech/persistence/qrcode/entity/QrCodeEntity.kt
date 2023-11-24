package br.com.agrotech.persistence.qrcode.entity

import br.com.agrotech.persistence.animal.entity.AnimalEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_qrcode")
class QrCodeEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    @Lob
    @Column(length = 1000)
    var data: ByteArray? = null,
    @OneToOne @JoinColumn(name = "animal_id")
    var animal: AnimalEntity? = null
)