package dp.patterns.statereduction

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */
class MinCostClimbingStairs {
    private val memo = mutableMapOf<Int, Int>()

    fun minCostClimbingStairs(cost: IntArray): Int {
        return dp(cost.size-1, cost)
    }

    private fun dp(currentStep: Int, cost: IntArray): Int {
        if (currentStep <= 1) {
            return 0
        }
        if (!memo.containsKey(currentStep)) {
            val plus1 = cost[currentStep - 1] + dp(currentStep - 1, cost)
            val plus2 = cost[currentStep - 2] + dp(currentStep - 2, cost)

            memo[currentStep] = plus1.coerceAtMost(plus2)
        }
        return memo[currentStep] ?: 0
    }
}