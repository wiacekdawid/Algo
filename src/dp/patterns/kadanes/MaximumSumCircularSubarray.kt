package dp.patterns.kadanes

/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 * A circular array means the end of the array connects to the beginning of the array.
 * Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 * A subarray may only include each element of the fixed buffer nums at most once.
 * Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 */

fun main() {
    val test = MaximumSumCircularSubarray().maxSubarraySumCircular(intArrayOf(5,-3,5))
    val test1 = test
}

// Time O(n), space O(1)
class MaximumSumCircularSubarray {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var totalSum = 0
        var minSum = nums.first()
        var currMin = 0
        var maxSum = nums.first()
        var currMax = 0
        nums.forEach {
            currMax = currMax.coerceAtLeast(0) + it
            maxSum = maxSum.coerceAtLeast(currMax)
            currMin = currMin.coerceAtMost(0) + it
            minSum = minSum.coerceAtMost(currMin)
            totalSum += it
        }

        return if (totalSum == minSum) maxSum else (totalSum - minSum).coerceAtLeast(maxSum)
    }
}