package com.manwal.kotlinpractice

fun main() {

    val p1 = Person("AKM", 30)
    val p2 = Person("AKM", 30)

    println(p1) // toString calling
    println(p2)

    // A unique number for an object
    println(p1.hashCode())

    // The root of the Kotlin class hierarchy. Every Kotlin class has Any as a superclass.
    // p1.equals(p2) in java
    println(p1 == p2)

    // copy() method
    val p3 = p1.copy(name = "Ashish")
    println(p3)

    // Destructuring declaration
    val (name, age) = p1
    println(name)
    println(age)
    println(p1.component1()) // Component functions
    println(p1.component2())

}

// By default includes all methods of Any class unlike java where we need to override them
// toString(), hashCode(), equals() comes from "Any" class
data class Person(var name: String, var age: Int)