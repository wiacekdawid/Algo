package dp.patterns

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */

fun main() {
    val test = LongestIncreasingSubsequence().lengthOfLIS2(intArrayOf(0,1,0,3,2,3))
}

class LongestIncreasingSubsequence {

    // simplified time O(n pow 2) , time O(n)
    fun lengthOfLIS2(nums: IntArray): Int {
        val cache = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size)
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    cache[i] = cache[i].coerceAtLeast(cache[j] + 1)
                }
            }


        var maxValue = 0

        cache.forEach {
            maxValue = maxValue.coerceAtLeast(it)
        }

        return maxValue
    }

    // recursion
    private lateinit var maxForPosition: IntArray
    fun lengthOfLIS(nums: IntArray): Int {
        maxForPosition = IntArray(nums.size) { -1 }
        for (i in nums.indices)
            dp(i, nums)

        var maxValue = 0

        maxForPosition.forEach {
            maxValue = maxValue.coerceAtLeast(it)
        }

        return maxValue
    }

    private fun dp(currentPosition: Int, nums: IntArray): Int {
        if (maxForPosition[currentPosition] != -1) {
            maxForPosition[currentPosition]
        } else {
            if (currentPosition == nums.size-1) {
                maxForPosition[currentPosition] = 1
            } else {
                var currentMax = 1
                for (i in currentPosition+1 until nums.size) {
                    if (nums[i] > nums[currentPosition]) {
                        currentMax = currentMax.coerceAtLeast(1 + dp(i, nums))
                    }
                }
                maxForPosition[currentPosition] = currentMax
            }
        }
        return maxForPosition[currentPosition]
    }
}