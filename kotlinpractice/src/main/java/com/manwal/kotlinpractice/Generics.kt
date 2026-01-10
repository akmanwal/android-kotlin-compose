package com.manwal.kotlinpractice

fun main() {

    val strContainer = Container("Ashish")
    println(strContainer.getValue())

    val intContainer = Container(7)
    println(intContainer.getValue())

    // Array of values
    varArguments("a","b","c","d")
}

class Container<T>(var data: T) {

    fun setValue(value: T) {
        data = value
    }

    fun getValue(): T {
        return data
    }
}

fun varArguments(vararg num: String) {
    var sum = ""
    for (i in num) {
        sum.apply {
            sum += i
        }
    }
    println(sum)
}