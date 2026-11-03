package com.korebit.service

import com.korebit.dto.Product
import com.korebit.dto.ProductNotFoundException

class ProductService {
    private val products = listOf(
        Product(1, "Agua", 12.5, true),
        Product(2, "Refresco", 18.0, true)
    )

    fun findById(id: Int): Product {
        return products.find { it.id == id }
            ?: throw ProductNotFoundException(id)
    }
}