package com.korebit

import com.korebit.dto.Product
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello, World!")
        }
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/api/products"){
            val list = listOf(
                Product(1, "Soda", 20.10),
                Product(2, "Milk", 10.10),
                Product(3, "Cheese", 18.10))

            call.respond(list)
        }

        post("/api/products") {
            val product = call.receive<Product>()

            call.respond(
                HttpStatusCode.Created,
                product
            )
        }
    }
}