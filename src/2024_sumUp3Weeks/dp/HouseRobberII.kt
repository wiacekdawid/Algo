package `2024_sumUp3Weeks`.dp

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

// time / space O(n)
class HouseRobberII {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0] // Edge case: only one house

        fun helper(start: Int, end: Int): Int {
            val memo = IntArray(size = nums.size) { -1 }

            fun robFrom(currentHouse: Int): Int {
                if (currentHouse > end) return 0
                if (memo[currentHouse] != -1) return memo[currentHouse]

                memo[currentHouse] = maxOf(
                    robFrom(currentHouse + 1), // Skip the current house
                    nums[currentHouse] + robFrom(currentHouse + 2) // Rob the current house
                )
                return memo[currentHouse]
            }

            return robFrom(start)
        }

        // Scenario 1: Rob houses from 0 to n-2
        // Scenario 2: Rob houses from 1 to n-1
        return maxOf(helper(0, nums.size - 2), helper(1, nums.size - 1))
    }
}