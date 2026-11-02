package com.korebit

import com.korebit.dto.CreateProductRequest
import com.korebit.dto.Product
import com.korebit.dto.ProductResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        route("/api/products") {
            get {
                val active = call.request.queryParameters["active"]
                    ?.toBooleanStrictOrNull()

                val list = listOf(
                    Product(1, "Soda", 20.10),
                    Product(2, "Milk", 10.10),
                    Product(3, "Cheese", 18.10)
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
                val id = call.parameters["id"]?.toIntOrNull()

                if (id == null) {
                    call.respond(HttpStatusCode.BadRequest, "Invalid id")
                    return@get
                }

                call.respondText { "Product: $id" }
            }
        }
    }
}