package com.korebit.function

fun main() {
    val n1: (Int, Int) -> Int = { a, b -> a + b }

    println(n1)
}

fun operation(num1: Double, num2: Double, op: (Double, Double) -> Double) = op(num1, num2)