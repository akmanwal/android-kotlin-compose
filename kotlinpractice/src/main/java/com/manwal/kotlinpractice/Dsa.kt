package com.manwal.kotlinpractice

fun main() {
    val unsortedArray = intArrayOf(1, 5, 4, 3, 2)
    println(unsortedArray.sortedArray().contentToString())
    bubbleSort(unsortedArray)
    println(unsortedArray.contentToString())
    for (i in unsortedArray.indices) {
        println(unsortedArray[i])
    }
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