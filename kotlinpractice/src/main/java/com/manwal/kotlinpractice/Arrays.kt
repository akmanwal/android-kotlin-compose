package com.manwal.kotlinpractice

fun main() {

    val unsortedArray = intArrayOf(0, 4, 3, 5, 2, 6, 7, 1)
    sortedArray(unsortedArray)
    println(unsortedArray.contentToString())

    val arr = intArrayOf(1, 2, 3, 4, 5)
    reverseArray(arr)
    println(arr.contentToString())

    val arr1 = intArrayOf(10, 4, 20, 50, 2, 100, 6)
    findMax(arr1)

    val runningArr = intArrayOf(1,2,3,4)
    runningSum(runningArr)
}

// sorting an array
private fun sortedArray(arr: IntArray) {

    for (i in 0 until arr.size) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

// reverse an array
private fun reverseArray(arr: IntArray) {

    var left = 0
    var right = arr.size - 1
    while (left < right) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left++
        right--
    }
}

// find max in an array
private fun findMax(arr: IntArray) {
    var max = arr[0]
    for (i in 0 until arr.size) {
        if (arr[i] > max) {
            max = arr[i]
        }
    }
    println(max)
}

// running sun of an array
fun runningSum(arr: IntArray) {
    for (i in 1 until arr.size) {
        arr[i] = arr[i] + arr[i - 1]
    }
    println(arr.contentToString())
}