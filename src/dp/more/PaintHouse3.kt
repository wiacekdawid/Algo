package dp.more

/**
 * There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n),
 * some houses that have been painted last summer should not be painted again.
 * A neighborhood is a maximal group of continuous houses that are painted with the same color.
 * For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].
 * Given an array houses, an m x n matrix cost and an integer target where:
 * houses[i]: is the color of the house i, and 0 if the house is not painted yet.
 * cost[i][j]: is the cost of paint the house i with the color j + 1.
 * Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods.
 * If it is not possible, return -1.
 */

fun main() {
    val test = PaintHouse3().minCost(
        houses = intArrayOf(0,0,0,0,0),
        cost = arrayOf(intArrayOf(1,10),intArrayOf(10,1),intArrayOf(10,1),intArrayOf(1,10),intArrayOf(5,1)),
        m = 5,
        n = 2,
        target = 3
    )
}
class PaintHouse3 {
    /**
     * top down with memoizaiton time/space complexity O(m*n*t)
     */
    private lateinit var cache: Array<Array<IntArray>>
    private val MAX_COST = 1000001

    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        cache = Array(m + 1) { Array(n+1) { IntArray(target+1) { -1 } } }
        val minCost = dp(houses, cost, target, n, 0, 0, 0)
        if (minCost == MAX_COST)
            return -1
        return minCost
    }

    private fun dp(houses: IntArray,
                   cost: Array<IntArray>,
                   target: Int,
                   totalColors: Int,
                   currentHouse: Int,
                   previousHouseColor: Int,
                   neighborhoodCount: Int): Int {
        if (currentHouse == houses.size) {
            return if (neighborhoodCount == target) 0 else MAX_COST
        }

        if (neighborhoodCount > target) {
            return MAX_COST
        }

        if (cache[currentHouse][previousHouseColor][neighborhoodCount] == -1) {
            cache[currentHouse][previousHouseColor][neighborhoodCount] =
                if (houses[currentHouse] != 0) {
                    val nextNeighborhoodCount = neighborhoodCount +
                            if (houses[currentHouse] != previousHouseColor) 1 else 0
                    dp(houses, cost, target, totalColors, currentHouse+1, houses[currentHouse], nextNeighborhoodCount)
                } else {
                    var minCost = MAX_COST
                    for (nextColor in 1 until totalColors+1) {
                        val nextNeighborhoodCount = neighborhoodCount + if (nextColor != previousHouseColor) 1 else 0
                        val currentCost = cost[currentHouse][nextColor-1] +
                                dp(houses, cost, target, totalColors, currentHouse+1, nextColor, nextNeighborhoodCount)
                        minCost = minCost.coerceAtMost(currentCost)
                    }
                    minCost
                }
        }

        return cache[currentHouse][previousHouseColor][neighborhoodCount]
    }

    /**
     * bottom up time/space complexity O(m*n*t)
     */
    private val maxCost = 1000001

    fun minCost2(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val cache: Array<Array<IntArray>>
        return 0
    }
}