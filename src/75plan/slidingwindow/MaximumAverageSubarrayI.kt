package `75plan`.slidingwindow

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 */

fun main() {
    val test = MaximumAverageSubarrayI().findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4)
}

// time O(n) / space O(1)
class MaximumAverageSubarrayI {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        if (nums.size < k) return 0.0

        var currentSum = 0.0

        for (i in 0 until k) {
            currentSum += nums[i]
        }

        var currentMax = currentSum / k

        for ((indexMin, indexMax) in (k until nums.size).withIndex()) {
            currentSum = currentSum - nums[indexMin] + nums[indexMax]
            currentMax = currentMax.coerceAtLeast(currentSum/k)
        }

        return currentMax
    }
}