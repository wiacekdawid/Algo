package `2024_restart`.noplan

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */

// time O(n) / space O(1)
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var farthest = 0

        for (i in nums.indices) {
            // If we can't reach this position, return false
            if (i > farthest) {
                return false
            }
            // Update the farthest reachable index
            farthest = maxOf(farthest, i + nums[i])

            // Early exit if we can already reach the last index
            if (farthest >= nums.lastIndex) {
                return true
            }
        }

        return true
    }
}