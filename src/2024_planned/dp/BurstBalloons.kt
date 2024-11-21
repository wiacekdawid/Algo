package `2024_planned`.dp

/**
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums.
 * You are asked to burst all the balloons.
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array,
 * then treat it as if there is a balloon with a 1 painted on it.
 * Return the maximum coins you can collect by bursting the balloons wisely.
 */
// time O(n pow3) / space O(n pow2)
class BurstBalloons {
    fun maxCoins(nums: IntArray): Int {
        val paddedNums = IntArray(nums.size + 2)
        paddedNums[0] = 1
        paddedNums[nums.size + 1] = 1
        for (i in nums.indices) {
            paddedNums[i + 1] = nums[i]
        }

        val n = paddedNums.size
        val dp = Array(n) { IntArray(n) }

        // Solve for ranges of increasing size
        for (length in 2 until n) { // Length of the range
            for (i in 0 until n - length) { // Start of the range
                val j = i + length // End of the range
                for (k in i + 1 until j) { // Choose a balloon to burst last
                    dp[i][j] = maxOf(
                        dp[i][j],
                        dp[i][k] + paddedNums[i] * paddedNums[k] * paddedNums[j] + dp[k][j]
                    )
                }
            }
        }

        return dp[0][n - 1]
    }
}