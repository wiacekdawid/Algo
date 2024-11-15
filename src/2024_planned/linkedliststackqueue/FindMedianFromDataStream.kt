package `2024_planned`.linkedliststackqueue

import java.util.*

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
class FindMedianFromDataStream {
    // space O(n)
    // Max-heap for the smaller half of the numbers
    private val stackLeft = PriorityQueue<Int>(compareByDescending { it })

    // Min-heap for the larger half of the numbers
    private val stackRight = PriorityQueue<Int>()

    // time O(logN)
    fun addNum(num: Int) {
        // Step 1: Add to stackLeft (max-heap)
        stackLeft.add(num)

        // Step 2: Move the largest number in stackLeft to stackRight (min-heap)
        stackRight.add(stackLeft.poll())

        // Step 3: Balance the heaps (ensure stackLeft is larger or equal in size)
        if (stackLeft.size < stackRight.size) {
            stackLeft.add(stackRight.poll())
        }
    }

    // time O(1)
    fun findMedian(): Double {
        return if (stackLeft.size > stackRight.size) {
            stackLeft.peek().toDouble()
        } else {
            (stackLeft.peek() + stackRight.peek()) / 2.0
        }
    }
}