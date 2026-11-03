package com.korebit

import com.korebit.dto.CreateProductRequest
import com.korebit.dto.InvalidProductException
import com.korebit.dto.Product
import com.korebit.dto.ProductResponse
import com.korebit.service.ProductService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        route("/api/products") {
            get {
                val active = call.request.queryParameters["active"]
                    ?.toBooleanStrictOrNull()

                val list = listOf(
                    Product(1, "Soda", 20.10, true),
                    Product(2, "Milk", 10.10, true),
                    Product(3, "Cheese", 18.10, false)
                )

                call.respond(list)
            }

            post {
                val product = call.receive<CreateProductRequest>()
                val response = ProductResponse(
                    10,
                    product.name,
                    product.price,
                )


                call.respond(
                    HttpStatusCode.Created,
                    response
                )
            }

            get("/{id}") {
                val productService = ProductService()
                val id = call.parameters["id"]?.toIntOrNull()

                if (id == null || id <= 0) {
                    throw InvalidProductException("Invalid product ID")
                }

                val product = productService.findById(id)

                call.respond(product)
            }
        }
    }
}