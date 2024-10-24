package `2024_planned`.sortingBinarySearch

import java.util.*

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */

class KthLargestElementInAnArray {
    // time O(nlogk) / space O(k)
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // Min-heap to store the top k largest elements
        val queue = PriorityQueue<Int>()

        nums.forEach { num ->
            queue.add(num)
            if (queue.size > k) {
                queue.poll()  // Remove the smallest element when the size exceeds k
            }
        }

        // The root of the min-heap will be the kth largest element
        return queue.poll()
    }
}