package com.korebit.concurrence

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {

    val result = doSomethingUsefulOne()
    println("The answer is $result")

    launch {
        delay(1000L.milliseconds)
        println("World!")
    }

    val job2 = launch {
        delay(400L.milliseconds)
        println("from")
    }

    val job = launch {
        println("main")
    }

    job2.join()
    println("Hello,")
    job.join()
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L.milliseconds) // Simulate a long-running computation
    return 13
}