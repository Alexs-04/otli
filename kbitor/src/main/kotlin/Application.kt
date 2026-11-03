package com.korebit
import com.korebit.plugin.configureStatusPages
import io.ktor.server.application.*

fun Application.module() {
    configureStatusPages()
}