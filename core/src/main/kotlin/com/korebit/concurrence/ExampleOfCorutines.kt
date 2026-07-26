package com.korebit.concurrence

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val result = doSomethingUsefulOne()
    println("The answer is $result")

    launch {
        delay(1000L)
        println("World!")
    }

    val job2 = launch {
        delay(400L)
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
    delay(1000L) // Simulate a long-running computation
    return 13
}