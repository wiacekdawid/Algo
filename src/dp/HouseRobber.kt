package dp

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 */

fun main() {
    val result = HouseRobber().rob2(intArrayOf(7,8,9,10,11,12))
}

class HouseRobber {

    /**
     * top down with memoizaiton time/space complexity O(n)
     */
    private val map = mutableMapOf<Int, Int>()

    fun rob(nums: IntArray): Int {
        return dp(0, nums)
    }

    private fun dp(i: Int, nums: IntArray): Int {
        if (i >= nums.size) {
            return 0
        }

        if (!map.containsKey(i)) {
            map[i] =  dp(i + 1, nums).coerceAtLeast(nums[i] + dp(i + 2, nums))
        }

        return map[i] ?: 0
    }

    /**
     * bottom up time/space complexity O(n)
     */
    fun rob2(nums: IntArray): Int {
        val numsSize = nums.size

        if (numsSize == 0) {
            return 0
        }

        val maxRobbedAmount = IntArray(size = numsSize+1)

        maxRobbedAmount[numsSize] = 0
        maxRobbedAmount[numsSize-1] = nums[numsSize-1]

        for (i in numsSize-2 downTo 0) {
            maxRobbedAmount[i] = maxRobbedAmount[i+1].coerceAtLeast(maxRobbedAmount[i+2] + nums[i])
        }

        return maxRobbedAmount[0]
    }
}