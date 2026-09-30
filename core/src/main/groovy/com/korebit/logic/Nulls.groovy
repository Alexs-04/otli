package com.korebit.logic

def describe(value) {
    if (value) {
        println "Válido"
    } else {
        println "Valor vacío"
    }
}

describe(null)
describe("")
describe("Groovy")
describe([])
describe([1, 2, 3])
describe(0)
describe(42)

def greet = {
    println "any"
}

greet()

def otherGreet = {
    name -> "Hello $name"
}

println otherGreet("Alex")

def square = { number ->
    number * number
}

println square(3)