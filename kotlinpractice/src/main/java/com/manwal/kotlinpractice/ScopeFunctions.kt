package com.manwal.kotlinpractice

fun main() {
    val person = Someone("", 0)
    person.name = "abc"
    person.age = 25

    val person2: Someone? = null
    person2?.name = "def"
    person2?.age = 30

    // Most used in kotlin-> apply, let

    // return-> modified object
    // Advantage when we want to write object name again and again
    person.apply {
        name = "abc"
        age = 25
    }

    println(person)

    // return -> last expression
    person.let {
        println(it.name)
        println(it.age)
        5
    }

    // works with safe call operator
    // return -> modified object
    person2?.let {
        it.name = "abc"
        it.age = 25
    }

    // same as let but no need to use it it directly access the object
    // returns last expression
    with(person) {
        name = "abc"
        age = 25
    }

    // combination of with and let
    // returns last expression
    person.run {
        name = "abc"
        age = 25
    }
}

data class Someone(
    var name: String = "",
    var age: Int = 25
)