package dp.patterns

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */

fun main() {
    val test = LongestIncreasingSubsequence().lengthOfLIS(intArrayOf(0,1,0,3,2,3))
}

class LongestIncreasingSubsequence {
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