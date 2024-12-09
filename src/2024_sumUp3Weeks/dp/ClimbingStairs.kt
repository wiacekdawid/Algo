package `2024_sumUp3Weeks`.dp

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

// time O(n) / space O(1)
class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        val memo = IntArray(size = n + 1) { -1 }

        fun helper(current: Int): Int {
            if (current > n) return 0 // No ways if we've exceeded the stairs
            if (current == n) return 1 // One way if we're exactly at the top

            // Use memoized result if available
            if (memo[current] != -1) return memo[current]

            // Calculate and store the result
            memo[current] = helper(current + 1) + helper(current + 2)
            return memo[current]
        }

        return helper(0) // Start from the bottom (step 0)
    }
}