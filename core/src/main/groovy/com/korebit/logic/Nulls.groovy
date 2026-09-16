package com.korebit.logic

def describe(value) {
    if (value) {
        println "Válido"
    } else {
        println "No Válido"
    }
}

describe(null)
describe("")
describe("Groovy")
describe([])
describe([1, 2, 3])
describe(0)
describe(42)