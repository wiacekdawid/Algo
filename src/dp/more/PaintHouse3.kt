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
     * top down with memoizaiton time O(n kpow2)/space complexity O(nk)
     */
    private lateinit var cache: Array<Array<IntArray>>
    private lateinit var houses: IntArray
    private lateinit var cost: Array<IntArray>
    private var m = 0
    private var n = 0
    private var target = 0

    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        cache = Array(m + 1) { Array(n+1) { IntArray(target+1) { -1 } } }
        this.houses = houses
        this.cost = cost
        this.m = m
        this.n = n
        this.target = target
        return dp(m, n, target)
    }

    private fun dp(currentHouse: Int, currentlyUsedColor: Int, remainingTarget: Int): Int {
        if (currentHouse == 0) {
            return if (remainingTarget == 0) {
                if (houses[currentHouse] == 0) {
                    cost[0][currentlyUsedColor]
                } else if (houses[currentHouse] == currentlyUsedColor+1) {
                    0
                } else {
                    -1
                }
            } else if (remainingTarget > 1) {
                -1
            } else if (remainingTarget == 1) {
                if (houses[currentHouse] == 0) {
                    cost[0].filterIndexed { index, _ -> index != currentlyUsedColor  }.min() ?: -1
                } else if (houses[currentHouse] == currentlyUsedColor+1) {
                    -1
                } else {
                    0
                }
            } else {
                -1
            }
        }

        if (cache[currentHouse][currentlyUsedColor][remainingTarget] == -1) {
            cache[currentHouse][currentlyUsedColor][remainingTarget] = if (currentHouse == m) {
                var smallestOutput = Int.MAX_VALUE
                for (currentColor in 0 until n) {
                    val forCurrentColor = dp(currentHouse - 1, currentColor, target-1)
                    if (forCurrentColor != -1) {
                        println("[$currentHouse][$currentlyUsedColor][$remainingTarget] forCurrentColor = ${forCurrentColor}")
                        smallestOutput = smallestOutput.coerceAtMost(forCurrentColor)
                    }
                }
                smallestOutput
            } else {
                var smallestOutput = Int.MAX_VALUE
                println("smallestOutput = ${smallestOutput}")
                if (houses[currentHouse] != 0 && houses[currentHouse] != currentlyUsedColor+1) {
                    smallestOutput = -1
                } else {
                    for (currentColor in 0 until n) {
                        if (remainingTarget > 0) {
                            smallestOutput = if (currentColor != currentlyUsedColor) {
                                val forCurrentColor = dp(currentHouse - 1, currentColor, remainingTarget - 1)
                                if (forCurrentColor != -1)
                                    smallestOutput.coerceAtMost(forCurrentColor)
                                else
                                    smallestOutput
                            } else {
                                val forCurrentColor = dp(currentHouse - 1, currentColor, remainingTarget)
                                if (forCurrentColor != -1)
                                    smallestOutput.coerceAtMost(forCurrentColor)
                                else
                                    smallestOutput
                            }
                        } else {
                            if (currentColor == currentlyUsedColor) {
                                val forCurrentColor = dp(currentHouse - 1, currentColor, remainingTarget)
                                if (forCurrentColor != -1)
                                    smallestOutput =
                                        smallestOutput.coerceAtMost(forCurrentColor)
                                else
                                    smallestOutput
                            }
                        }
                    }
                }
                println("smallestOutput for $currentHouse = ${smallestOutput}")
                if (smallestOutput != Int.MAX_VALUE)
                (if (houses[currentHouse] == 0) cost[currentHouse][currentlyUsedColor] else 0) + smallestOutput
                else
                    smallestOutput
            }
        }

        println("[$currentHouse][$currentlyUsedColor][$remainingTarget] = ${cache[currentHouse][currentlyUsedColor][remainingTarget]}")
        return cache[currentHouse][currentlyUsedColor][remainingTarget]
    }
}