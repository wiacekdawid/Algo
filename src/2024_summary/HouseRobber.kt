package `2024_summary`

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
class HouseRobber {
    // time / space O(n)
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val memo = IntArray(nums.size) { -1 }

        fun dp(currentHouse: Int): Int {
            if (currentHouse >= nums.size) return 0 // Base case: no more houses to rob

            if (memo[currentHouse] != -1) return memo[currentHouse] // Return cached result

            // Rob current house and skip next, or skip current house
            memo[currentHouse] = maxOf(
                nums[currentHouse] + dp(currentHouse + 2),
                dp(currentHouse + 1)
            )
            return memo[currentHouse]
        }

        return dp(0)
    }
}