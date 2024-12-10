package `2024_sumUp3Weeks`.dp

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */

// time / space O(n)
class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val memo = IntArray(size = cost.size) { -1 }

        fun helper(currentStep: Int): Int {
            if (currentStep >= cost.size) {
                return 0 // No cost after the last step
            }

            if (memo[currentStep] != -1) {
                return memo[currentStep]
            }

            // Calculate the minimum cost from this step
            memo[currentStep] = cost[currentStep] + minOf(
                helper(currentStep + 1), // Take one step
                helper(currentStep + 2)  // Take two steps
            )
            return memo[currentStep]
        }

        // Minimum cost to start from step 0 or step 1
        return minOf(helper(0), helper(1))
    }
}