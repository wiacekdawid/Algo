package `2024_summary`

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class ClimbingStairs {
    // time / space O(n)
    fun climbStairs(n: Int): Int {
        val memo = IntArray(size = n + 1) { -1 }

        fun dp(currentStep: Int): Int {
            // Base cases
            if (currentStep > n) return 0
            if (currentStep == n) return 1

            // Use memoized value if available
            if (memo[currentStep] != -1) return memo[currentStep]

            // Compute the value and store it in memo
            memo[currentStep] = dp(currentStep + 1) + dp(currentStep + 2)
            return memo[currentStep]
        }

        return dp(0)
    }
}