package `2024_planned`.dp

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
class MinimumPathSum {
    // time O(m*n) / space O(1)
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0

        val m = grid.size
        val n = grid[0].size

        // Update the grid in place to act as the DP table
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (i == 0 && j == 0) continue // Top-left corner, no update needed
                val top = if (i > 0) grid[i - 1][j] else Int.MAX_VALUE
                val left = if (j > 0) grid[i][j - 1] else Int.MAX_VALUE
                grid[i][j] += minOf(top, left)
            }
        }

        return grid[m - 1][n - 1] // Bottom-right cell contains the minimum path sum
    }
}