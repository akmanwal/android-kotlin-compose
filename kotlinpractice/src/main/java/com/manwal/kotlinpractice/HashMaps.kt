package com.manwal.kotlinpractice

// Write a Kotlin function that merges two maps of type Map by adding values for matching keys and keeping unique keys intact.
// Demonstrate with a sample input and output

fun main() {
    val map1 = mutableMapOf("Apple" to 10, "Banana" to 20, "Orange" to 30)
    val map2 = mutableMapOf("Ashish" to 10, "Manwal" to 20, "Apple" to 30)
    mergeMaps(map1, map2)
}

private fun mergeMaps(map1: MutableMap<String, Int>, map2: MutableMap<String, Int>) {

    val result = map1.toMutableMap()

    for ((key, value) in map2) {
        result[key] = (result[key] ?: 0) + value
    }
    println(result)
}