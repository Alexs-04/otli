package com.korebit.plugin

import com.korebit.dto.ErrorResponse
import com.korebit.dto.InvalidProductException
import com.korebit.dto.ProductNotFoundException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {

    install(StatusPages) {

        exception<ProductNotFoundException> { call, cause ->
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponse(
                    code = "PRODUCT_NOT_FOUND",
                    message = cause.message ?: "Product not found"
                )
            )
        }

        exception<InvalidProductException> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest,
                ErrorResponse(
                    code = "INVALID_PRODUCT",
                    message = cause.message ?: "Invalid product"
                )
            )
        }

        exception<Throwable> { call, cause ->
            this@configureStatusPages.environment.log.error(
                "Unhandled application exception",
                cause
            )

            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResponse(
                    code = "INTERNAL_SERVER_ERROR",
                    message = "An unexpected error occurred"
                )
            )
        }
    }
}