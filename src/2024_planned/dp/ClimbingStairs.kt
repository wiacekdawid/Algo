package `2024_planned`.dp

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

// time/ space O(n)
class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        val memo = IntArray(n + 1) { -1 }
        return climbStairsHelper(n, memo)
    }

    private fun climbStairsHelper(n: Int, memo: IntArray): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        if (memo[n] != -1) return memo[n]

        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo)
        return memo[n]
    }
}