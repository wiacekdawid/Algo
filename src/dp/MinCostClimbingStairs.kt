package dp


/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */

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
     * bottom - up / time/space O(N)
     */
    fun minCostClimbingStairs2(cost: IntArray): Int {
        val array = IntArray(cost.size+1)

        for (i in 2 until array.size) {
            val oneStepPlus = array[i-1] + cost[i-1]
            val twoStepPlus = array[i-2] + cost[i-2]
            array[i] = oneStepPlus.coerceAtMost(twoStepPlus)
        }

        return array[cost.size]
    }
}