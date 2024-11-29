package `2024_sumUp3Weeks`.stringsAndArrays

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */

// time O(n) / space O(1)
class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var currentMax = nums[0]
        var currentMin = nums[0]
        var globalMax = nums[0]

        for (i in 1 until nums.size) {
            val tempMax = currentMax
            currentMax = maxOf(nums[i], nums[i] * currentMax, nums[i] * currentMin)
            currentMin = minOf(nums[i], nums[i] * tempMax, nums[i] * currentMin)

            globalMax = maxOf(globalMax, currentMax)
        }

        return globalMax
    }
}