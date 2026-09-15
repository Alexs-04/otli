def x = 100
print x //I don't know this form, it is very similar to Ruby

class Person {
    String name
    int age
}

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

class Student extends Person {
    int identifier
}

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