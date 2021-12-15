package dp

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 */

class HouseRobber {
    /**
     * top down with memoizaiton time/space complexity O(n)
     */
    private val map = mutableMapOf<Int, Int>()

    fun rob(nums: IntArray): Int {
        return dp(nums.size-1, nums)
    }

    private fun dp(i: Int, nums: IntArray): Int {
        if (i == 0) return nums[i]
        if (i == 1) return nums[1].coerceAtLeast(nums[0])
        if (!map.containsKey(i)) {
            map[i] = dp(i-1, nums).coerceAtLeast(dp(i-2, nums) + nums[i])
        }
        return map[i] ?: 0
    }

    /**
     * bottom up time/space complexity O(n)
     */
    fun rob2(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val dp = IntArray(nums.size)

        dp[0] = nums[0]
        dp[1] = nums[1].coerceAtLeast(nums[0])

        for (i in 2 until nums.size) {
            dp[i] = dp[i-1].coerceAtLeast(dp[i-2] + nums[i])
        }

        return dp[nums.size-1]
    }
}