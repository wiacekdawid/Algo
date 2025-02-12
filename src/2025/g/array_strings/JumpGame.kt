package `2025`.g.array_strings

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
class JumpGame {
    // time / space O(n)
    fun canJump(nums: IntArray): Boolean {
        val memo = HashMap<Int, Boolean>()

        fun dp(currentPos: Int): Boolean {
            if (currentPos >= nums.size - 1) return true  // Reached last index
            if (memo.containsKey(currentPos)) return memo[currentPos]!!

            for (i in 1..nums[currentPos]) {
                if (dp(currentPos + i)) {
                    memo[currentPos] = true
                    return true
                }
            }

            memo[currentPos] = false
            return false
        }

        return dp(0)
    }

    // greedy time O(n) / space O(1)

    fun canJump2(nums: IntArray): Boolean {
        var lastGoodIndex = nums.size - 1  // Start at the last index

        for (i in nums.size - 2 downTo 0) {  // Traverse backward
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i  // Update the last known reachable index
            }
        }

        return lastGoodIndex == 0  // If we can reach index 0, return true
    }
}