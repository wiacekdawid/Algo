package `2024_planned`.dp

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

// time/ space O(n)
class HouseRobber {
    fun rob(nums: IntArray): Int {
        val memo = IntArray(nums.size) { -1 }
        return robHelper(0, nums, memo)
    }

    private fun robHelper(currentHouse: Int, nums: IntArray, memo: IntArray): Int {
        if (currentHouse >= nums.size) return 0 // Base case: No more houses to rob

        if (memo[currentHouse] != -1) return memo[currentHouse] // Return cached result

        // Rob the current house and skip one, or skip the current house
        memo[currentHouse] = maxOf(
            nums[currentHouse] + robHelper(currentHouse + 2, nums, memo),
            robHelper(currentHouse + 1, nums, memo)
        )
        return memo[currentHouse]
    }
}