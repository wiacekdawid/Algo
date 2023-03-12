package dp.more

import kotlin.math.cos

/**
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 * For example, costs[0][0] is the cost of painting house 0 with the color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on...
 * Return the minimum cost to paint all houses.
 */
class PaintHouse {

    /**
     * top down with memoizaiton time/space complexity O(n)
     */
    private lateinit var cache: Array<IntArray>

    fun minCost(costs: Array<IntArray>): Int {
        cache = Array(costs.size + 1) { IntArray(3) { -1 } }
        return dp(costs.size, 0, costs)
    }

    fun dp(currentHouse: Int, currentlyUsedColor: Int, costs: Array<IntArray>): Int {
        if (currentHouse == 0) {
            return if (costs.size > 1) {
                costs.first()[currentlyUsedColor]
            } else if (costs.isNotEmpty()) {
                costs.first().min() ?: 0
            } else {
                0
            }
        }

        if (cache[currentHouse][currentlyUsedColor] == -1) {
            cache[currentHouse][currentlyUsedColor] = if (currentHouse == costs.size) {
                dp(currentHouse - 1, 0, costs).coerceAtMost(
                    dp(currentHouse - 1, 1, costs)
                        .coerceAtMost(dp(currentHouse - 1, 2, costs))
                )
            } else {
                val indexesToCheck = intArrayOf(0, 1, 2).filter { it != currentlyUsedColor }
                costs[currentHouse][currentlyUsedColor] + (dp(currentHouse - 1, indexesToCheck.first(), costs)
                    .coerceAtMost(
                        dp(
                            currentHouse - 1,
                            indexesToCheck[1],
                            costs
                        )
                    ))
            }
        }

        return cache[currentHouse][currentlyUsedColor]
    }

    /**
     * bottom up - time/space complexity O(n)
     */

    fun minCost2(costs: Array<IntArray>): Int {
        return if (costs.size > 1) {
            val cachePaint = Array(costs.size + 1) { IntArray(3) { -1 } }
            cachePaint[0][0] = costs[0][0]
            cachePaint[0][1] = costs[0][1]
            cachePaint[0][2] = costs[0][2]
            for (currentHouse in 1 until costs.size) {
                for (i in 0 until 3) {
                    val validIndexed = intArrayOf(0, 1, 2).filter { it != i }
                    cachePaint[currentHouse][i] = costs[currentHouse][i] +
                            cachePaint[currentHouse-1][validIndexed[0]]
                                .coerceAtMost(cachePaint[currentHouse-1][validIndexed[1]])
                }
            }
            return cachePaint[costs.size-1].min() ?: 0
        } else if (costs.isNotEmpty()) {
            costs.first().min() ?: 0
        } else {
            0
        }
    }

}