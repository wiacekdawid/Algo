package dp

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 */
class MaximumScoreFromPerformingMultiplicationOperations {
    private var memo: Array<IntArray>? = null

    private fun dp(i: Int, left: Int, nums: IntArray, multipliers: IntArray): Int {
        if (i == nums.size) {
            return 0 // Base case
        }
        val mult: Int = multipliers[i]
        val right = nums.size - 1 - (i - left)
        if (memo?.get(i)?.get(left) ?: 0 == 0) {
            // Recurrence relation
            memo?.get(i)?.set(left,
                (mult * nums[left] + dp(i + 1, left + 1, nums, multipliers))
                    .coerceAtLeast(mult * nums[right] + dp(i + 1, left, nums, multipliers))
            )
        }
        return memo?.get(i)?.get(left) ?: 0
    }

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        memo = Array(nums.size) { IntArray(multipliers.size) }
        return dp(0, 0, nums, multipliers)
    }
}