package dp


/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */

fun main() {
    val test = MinCostClimbingStairs().minCostClimbingStairs2(intArrayOf(10, 15, 20))
}
class MinCostClimbingStairs {

    /**
     * top down / O(N)
     */
    private val costMap = mutableMapOf<Int, Int>()
    fun minCostClimbingStairs(cost: IntArray): Int {
        return dp(cost.size, cost)
    }

    private fun dp(currentStep: Int, cost: IntArray): Int {
        if (currentStep <= 1)
            return cost[currentStep]

        if (!costMap.containsKey(currentStep)) {
            costMap[currentStep] = (cost[currentStep-1] + dp(currentStep-1, cost))
                .coerceAtMost(cost[currentStep-2] + dp(currentStep-2, cost))
        }

        return costMap[currentStep] ?: 0
    }

    /**
     * bottom - up / time O(N) / space O(1)
     */
    fun minCostClimbingStairs2(cost: IntArray): Int {
        var minusOne = 0
        var minusTwo = 0
        for (i in 2 until cost.size) {
            val temp = minusOne
            minusOne = (minusOne + cost[i-1]).coerceAtMost(minusTwo + cost[i-2])
            minusTwo = temp
        }

        return minusOne
    }
}