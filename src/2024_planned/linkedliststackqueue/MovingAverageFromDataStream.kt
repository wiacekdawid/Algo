package `2024_planned`.linkedliststackqueue

import java.util.ArrayDeque

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Implement the MovingAverage class:
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 */
// time O(1) / space O(size)
class MovingAverageFromDataStream(size: Int) {
    private val capacity = size
    private val queue = ArrayDeque<Int>()
    private var sum = 0

    fun next(`val`: Int): Double {
        if (queue.size >= capacity) {
            sum -= queue.removeFirst() // Subtract the element that's removed
        }
        queue.addLast(`val`)
        sum += `val` // Add the new element to the sum

        return sum.toDouble() / queue.size
    }
}