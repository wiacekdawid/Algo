package dp.more

/**
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Return the minimum cost to paint all houses.
 */

fun main() {
    val test = PaintHouse2().minCostII2(arrayOf(intArrayOf(1,5,3), intArrayOf(2,9,4)))
}

class PaintHouse2 {
    /**
     * top down with memoizaiton time O(n kpow2)/space complexity O(nk)
     */
    private lateinit var cache: Array<IntArray>

    fun minCostII(costs: Array<IntArray>): Int {
        cache = Array(costs.size + 1) { IntArray(costs.first().size) { -1 } }
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
                var smallestOutput = Int.MAX_VALUE
                for (currentColor in costs.first().indices) {
                    smallestOutput = smallestOutput.coerceAtMost(dp(currentHouse - 1, currentColor, costs))
                }
                smallestOutput
            } else {
                val indexesToCheck = costs.first().indices.filter { it != currentlyUsedColor }
                var smallestOutput = Int.MAX_VALUE
                for (currentColor in indexesToCheck) {
                    smallestOutput = smallestOutput.coerceAtMost(dp(currentHouse - 1, currentColor, costs))
                }
                costs[currentHouse][currentlyUsedColor] + smallestOutput
            }
        }

        return cache[currentHouse][currentlyUsedColor]
    }

    /**
     * bottom up - time O(n kpow2)/space complexity O(nk)
     */

    fun minCostII2(costs: Array<IntArray>): Int {
        return if (costs.size > 1) {
            val cachePaint = Array(costs.size + 1) { IntArray(costs.first().size) { -1 } }
            for (currentColor in costs.first().indices) {
                cachePaint[0][currentColor] = costs[0][currentColor]
            }
            for (currentHouse in 1 until costs.size) {
                for (i in costs.first().indices) {
                    val indexesToCheck = costs.first().indices.filter { it != i }
                    var smallestOutput = Int.MAX_VALUE
                    for (currentColor in indexesToCheck) {
                        smallestOutput = smallestOutput.coerceAtMost(cachePaint[currentHouse - 1][currentColor])
                    }
                    cachePaint[currentHouse][i] = costs[currentHouse][i] + smallestOutput
                }
            }
            return cachePaint[costs.size - 1].min() ?: 0
        } else if (costs.isNotEmpty()) {
            costs.first().min() ?: 0
        } else {
            0
        }
    }
}