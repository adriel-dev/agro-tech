package br.com.agrotech.web.image.util

import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class ImageUtils {

    fun isImageFileValid(file: MultipartFile): Boolean {
        val allowedExtensions = listOf("jpg", "jpeg", "png")
        val fileExtension = getFileExtension(file)
        return file.contentType?.startsWith("image/") == true && allowedExtensions.contains(fileExtension?.lowercase())
    }

    fun getFileExtension(file: MultipartFile): String? {
        return file.originalFilename?.substringAfterLast('.')
    }

}