package dp

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 */

fun main() {
    val test = MaximumScoreFromPerformingMultiplicationOperations()
        .maximumScore(nums = intArrayOf(1,2,3), multipliers = intArrayOf(3,2,1))
    val test1 = test
}

class MaximumScoreFromPerformingMultiplicationOperations {

    /**
     * top down - time/space O(N)
     */
    private var cache: Array<IntArray>? = null

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        cache = Array(multipliers.size) { IntArray(nums.size) { -1 } }
        return dp(0, 0, nums, multipliers)
    }

    private fun dp(i: Int, left: Int, nums: IntArray, multipliers: IntArray) : Int {
        if (i == multipliers.size) {
            return 0
        }

        cache?.let {
            if (it[i][left] != -1) {
                return it[i][left]
            }
            val right = nums.size - 1 - (i - left)

            val leftGain = multipliers[i] * nums[left] + dp(i + 1, left + 1, nums, multipliers)
            val rightGain = multipliers[i] * nums[right] + dp(i + 1, left, nums, multipliers)

            it[i][left] = leftGain.coerceAtLeast(rightGain)
            return it[i][left]

        } ?: return 0
    }

    /**
     * bottom - up - space/time O(pow 2 multipliers.size * nums.size)
     */
    fun maximumScore2(nums: IntArray, multipliers: IntArray): Int {
        val dp = Array(multipliers.size+1) { IntArray(nums.size+1)  { 0 } }

        for (mIndex in multipliers.size-1 downTo 0) {
            val currentMultiplier = multipliers[mIndex]

            for (left in mIndex downTo 0) {
                val right = nums.size - 1 - (mIndex - left)

                val leftGain = currentMultiplier * nums[left] + dp[mIndex+1][left+1]
                val rightGain = currentMultiplier * nums[right] + dp[mIndex+1][left]
                dp[mIndex][left] = leftGain.coerceAtLeast(rightGain)
            }
        }
        return dp[0][0]
    }
}