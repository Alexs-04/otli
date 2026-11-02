package com.korebit.dto

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
)


@Serializable
data class CreateProductRequest(
    val name: String,
    val price: Double,
)

@Serializable
data class ProductResponse(
    val id: Int,
    val name: String,
    val price: Double,
)