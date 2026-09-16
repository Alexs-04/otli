package com.korebit

import com.korebit.mapper.EmployeeMapper
import com.korebit.model.Person
import com.korebit.model.Student

def x = 100
print x //I don't know this form, it is very similar to Ruby


def personOne = new Person(name: "alex", age: 21)
println personOne.name

def language = "Kotlin"
def version = 2.2
def numbers = [1, 2, 3, 4, 5]

for (def i = 0; i < numbers.last; i++) {
    println numbers.get(i)
}

def persons = [personOne, new Person(name: language, age: version)]
persons.forEach { println it }

println "Kotlin is $version"


def students = [
        new Student(name: "Ana", age: 20, identifier: 1),
        new Student(name: "Luis", age: 17, identifier: 20),
        new Student(name: "Carlos", age: 22, identifier: 89),
        new Student(name: "Marisco".replaceAll("Marisco", "Vane"), identifier: 483, age: 19)
]

def adults = students.stream()
        .filter { it.age >= 19 }
        .map { it.name }
        .toList()

adults.forEach { println it }

println students.findAll { it.age >= 18 }.collect({ it.name })

def any = EmployeeMapper.mapper('alex', 10, 19)

int i = 0
while (any) {
    println any.name
    i++
    if (i >= 10) {
        break
    }
}