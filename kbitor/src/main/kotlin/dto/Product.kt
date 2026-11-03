package com.korebit.dto

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val active : Boolean,
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

class ProductNotFoundException(id: Int) :
    RuntimeException("Product with ID $id was not found")

class InvalidProductException(message: String) :
    RuntimeException(message)