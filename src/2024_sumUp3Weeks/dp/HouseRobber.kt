package `2024_sumUp3Weeks`.dp

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

// time / space O(n)
class HouseRobber {
    fun rob(nums: IntArray): Int {
        val memo = IntArray(size = nums.size) { -1 }

        fun helper(currentHouse: Int): Int {
            if (currentHouse >= nums.size)
                return 0

            if (memo[currentHouse] != -1)
                return memo[currentHouse]

            memo[currentHouse] = maxOf(
                helper(currentHouse + 1), // Skip the current house
                nums[currentHouse] + helper(currentHouse + 2) // Rob the current house
            )
            return memo[currentHouse]
        }

        return helper(0)
    }
}