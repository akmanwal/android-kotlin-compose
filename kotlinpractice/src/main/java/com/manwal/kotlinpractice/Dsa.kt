package com.manwal.kotlinpractice

fun main() {
    // Sorting an array
    val unsortedArray = intArrayOf(1, 5, 4, 3, 2)
    println(unsortedArray.sortedArray().contentToString())
    bubbleSort(unsortedArray)
    println(unsortedArray.contentToString())
    for (i in unsortedArray.indices) {
        println(unsortedArray[i])
    }

    // Reverse an string
    val name = "Ashish"
    println(stringReverse(name))

}

private fun bubbleSort(arr: IntArray): IntArray {
    for (i in 0 until arr.size) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

private fun stringReverse(str: String): String {
    var reversed = ""
    for (i in 0 until str.length) {
        reversed = str[i] + reversed
    }
    return reversed
}
