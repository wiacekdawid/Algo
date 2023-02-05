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

class MaximumSumCircularSubarray {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var maxSum = nums.first()
        var currentSum = nums.first()
        var currentNumOfElements = 0

        for (i in 0 until 2) {
            nums.forEachIndexed { index, value ->
                if (currentNumOfElements >= nums.size-1 || (index == 0 && i == 0)) {
                    currentNumOfElements = 1
                    currentSum = value
                } else {
                    if ((currentSum + value) < value) {
                        currentSum = value
                        currentNumOfElements = 1
                    } else {
                        currentSum += value
                        currentNumOfElements++
                    }
                }
                maxSum = currentSum.coerceAtLeast(maxSum)
            }
        }
        return maxSum
    }
}