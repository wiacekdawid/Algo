package `2024_planned`.dp

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */

class LongestIncreasingSubsequence {
    // time O(pow2n) / space O(n)
    fun lengthOfLIS(nums: IntArray): Int {
        val memo = IntArray(nums.size) { 1 }

        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    memo[i] = memo[i].coerceAtLeast(memo[j] + 1)
                }
            }
        }

        return memo.max() ?: 0
    }
}