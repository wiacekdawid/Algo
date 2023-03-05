package dp.patterns.pathsinmatrix

/**
 * Given a m x n grid filled with non-negative numbers, find a path
 * from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

fun main() {
    val test = MinimumPathSum().minPathSum(arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1)))
}

class MinimumPathSum {
    /**
     * bottom up space/time complexity O(m*x)
     */
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(size = grid.size) { IntArray(size = grid.first().size) }
        dp[0][0] = grid[0][0]

        for (row in grid.indices) {
            for (column in 0 until grid.first().size) {
                if (row != 0 || column != 0) {
                    val rowValue = if (row > 0) {
                        dp[row-1][column]
                    } else Int.MAX_VALUE
                    val columnValue = if (column > 0) {
                        dp[row][column-1]
                    } else Int.MAX_VALUE
                    dp[row][column] = grid[row][column] + rowValue.coerceAtMost(columnValue)
                }
            }
        }
        return dp[grid.size-1][grid.first().size-1]
    }

    /**
     * top down space/time complexity O(m*x)
     */
    private lateinit var cache: Array<IntArray>

    fun minPathSum2(grid: Array<IntArray>): Int {
        cache = Array(size = grid.size) { IntArray(size = grid.first().size) { -1 } }
        return dp(grid.size-1, grid.first().size-1, grid)
    }

    private fun dp(currentRow: Int, currentColumn: Int, grid: Array<IntArray>): Int {
        if (currentRow == 0 && currentColumn == 0) {
            return grid[0][0]
        }

        if (cache[currentRow][currentColumn] == -1) {
            val rowValue = if (currentRow > 0) {
                dp(currentRow-1, currentColumn, grid)
            } else Int.MAX_VALUE
            val columnValue = if (currentColumn > 0) {
                dp(currentRow, currentColumn-1, grid)
            } else Int.MAX_VALUE
            cache[currentRow][currentColumn] = grid[currentRow][currentColumn] + rowValue.coerceAtMost(columnValue)
        }

        return cache[currentRow][currentColumn]
    }
}