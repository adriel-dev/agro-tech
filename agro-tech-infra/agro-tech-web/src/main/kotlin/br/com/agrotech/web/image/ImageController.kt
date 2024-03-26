package br.com.agrotech.web.image

import br.com.agrotech.domain.image.port.api.usecase.FindImageByAnimalId
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity.ok
import java.util.*

@RestController
@RequestMapping("/api/v1/image")
class ImageController(
    private val findImageByAnimalId: FindImageByAnimalId
) {

    @GetMapping("/get/{animalId}", produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun getImageByAnimalId(@PathVariable animalId: String): ResponseEntity<ByteArray> {
        val headers = HttpHeaders().apply { contentType = MediaType.APPLICATION_OCTET_STREAM }
        return ok().headers(headers).body(findImageByAnimalId.find(UUID.fromString(animalId)))
    }

}