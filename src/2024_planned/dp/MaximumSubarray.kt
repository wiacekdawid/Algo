package `2024_planned`.dp

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */

// time O(n) / space O(1)
class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var currentMaxSum = Int.MIN_VALUE
        var currentSum = 0

        nums.forEach {
            // Decide whether to start a new subarray or continue the current one
            currentSum = maxOf(it, currentSum + it)

            // Update the maximum sum encountered so far
            currentMaxSum = maxOf(currentMaxSum, currentSum)
        }

        return currentMaxSum
    }
}