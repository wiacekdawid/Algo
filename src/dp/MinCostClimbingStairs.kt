package dp

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */

class MinCostClimbingStairs {
    /**
     * top down / time/space O(N)
     */
    private val map = HashMap<Int, Int>()

    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.isEmpty()) return 0
        if (cost.size == 1) return cost[1]
        return dp(cost.size, cost)
    }

    private fun dp(currentStep: Int, cost: IntArray): Int {
        if (currentStep <= 1) return 0
        if (!map.containsKey(currentStep)) {
            val oneStepPlus = dp(currentStep-1, cost) + cost[currentStep-1]
            val twoStepPlus = dp(currentStep-2, cost) + cost[currentStep-2]
            map[currentStep] = oneStepPlus.coerceAtMost(twoStepPlus)
        }
        return map[currentStep] ?: 0
    }

    /**
     * bottom - up / time/space O(N)
     */
    fun minCostClimbingStairs2(cost: IntArray): Int {
        if (cost.isEmpty()) return 0
        if (cost.size == 1) return cost[1]

        val array = IntArray(cost.size+1)

        for (i in 2 until array.size) {
            val oneStepPlus = array[i-1] + cost[i-1]
            val twoStepPlus = array[i-2] + cost[i-2]
            array[i] = oneStepPlus.coerceAtMost(twoStepPlus)
        }

        return array[cost.size]
    }
}