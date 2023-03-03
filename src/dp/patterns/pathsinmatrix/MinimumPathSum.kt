package dp.patterns.pathsinmatrix

/**
 * Given a m x n grid filled with non-negative numbers, find a path
 * from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(size = grid.size) { IntArray(size = grid.first().size) }
        dp[0][0] = grid[0][0]

        for (row in grid.indices) {
            for (column in 0 until grid.first().size) {
                val rowValue = if (row > 0) {
                    dp[row-1][column]
                } else 0
                val columnValue = if (column > 0) {
                    dp[row][column-1]
                } else 0
                dp[row][column] = grid[row][column] + rowValue.coerceAtMost(columnValue)
            }
        }
        return dp[grid.size-1][grid.first().size-1]
    }
}