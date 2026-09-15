package com.korebit.model

class Employee(
    var name: String,
    var age: Int,
    var id: Int
) {
    companion object {
        fun mapper(name: String): Employee {
            return Employee(name, 100, 211)
        }
    }
}