package `2024_sumUp3Weeks`.stringsAndArrays

import java.util.ArrayDeque

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 */
// time / space O(n)
class SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>()
        val result = IntArray(nums.size - k + 1)
        var resultIndex = 0

        for (i in nums.indices) {
            // Remove indices that are out of the current window
            if (deque.isNotEmpty() && deque.first() < i - k + 1) {
                deque.removeFirst()
            }

            // Remove elements from the back that are smaller than the current element
            while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
                deque.removeLast()
            }

            // Add the current index to the deque
            deque.addLast(i)

            // Start recording results once we have processed the first k elements
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.first()]
            }
        }

        return result
    }
}