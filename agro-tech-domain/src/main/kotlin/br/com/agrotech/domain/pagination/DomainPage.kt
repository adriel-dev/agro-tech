package br.com.agrotech.domain.pagination

data class DomainPage<T>(
    val content: List<T>,
    val totalPages: Int,
    val totalElements: Long,
    val pageSize: Int,
    val pageNumber: Int
)