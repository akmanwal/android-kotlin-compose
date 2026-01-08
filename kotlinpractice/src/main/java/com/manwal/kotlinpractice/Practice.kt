package com.manwal.kotlinpractice

fun main() {

    // Extension function
    val str = "Hello"
    val modifiedStr = str.addSomething()
    println(modifiedStr)

    // Inline function
    myInlineFun(3, 4) { a, b ->
        println(a + b)
    }

    // Function types
    val funType = ::myInlineFun
    funType.invoke(10,20) { a, b ->
        println(a + b)
    }

}

fun String.addSomething(): String {
    return "$this + extension string"
}

// Higher order function with inline function
inline fun myInlineFun(a: Int, b: Int, action: (Int, Int) -> Unit) {
    return action(a, b)
}