package com.manwal.kotlinpractice

fun main() {
    val outer = Outer()
    outer.num

    // First create the outer class object then nested class object
    // To access nested class members
    val nestedObj = Outer().Nested()
    nestedObj.doSomething()
}

class Outer {
    val num = 0

    inner class Nested() {
        fun doSomething() {
            // To access outer class members we need to make nested class with "inner"
            println("I am nested class $num")
        }
    }
}