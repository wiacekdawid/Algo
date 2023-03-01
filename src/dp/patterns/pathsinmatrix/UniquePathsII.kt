package dp.patterns.pathsinmatrix

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */

fun main() {
    val test = UniquePathsII().uniquePathsWithObstacles2(arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(0,0,0)))
}

class UniquePathsII {
    /**
     * bottom up space/time complexity O(m*x)
     */
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid.firstOrNull()?.size ?: 0

        if (obstacleGrid[m-1][n-1] == 1) {
            return 0
        }

        val dp = Array(size = m) { IntArray(size = n) }
        dp[0][0] = 1

        for (row in 0 until m) {
            for (column in 0 until n) {
                if (row > 0 && obstacleGrid[row-1][column] == 0) {
                    dp[row][column] += dp[row-1][column]
                }
                if (column > 0 && obstacleGrid[row][column-1] == 0) {
                    dp[row][column] += dp[row][column-1]
                }
            }
        }
        return dp[m-1][n-1]
    }

    /**
     * top down space/time complexity O(m*x)
     */
    private lateinit var cache: Array<IntArray>

    fun uniquePathsWithObstacles2(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid.firstOrNull()?.size ?: 0

        if (obstacleGrid[m-1][n-1] == 1) {
            return 0
        }

        cache = Array(size = m) { IntArray(size = n) { -1 } }

        return dp(m-1, n-1, obstacleGrid)
    }

    private fun dp(row: Int, column: Int, obstacleGrid: Array<IntArray>): Int {
        if (row == 0 && column == 0) {
            return 1
        }

        if (cache[row][column] == -1) {
            val rowPart = if (row > 0 && obstacleGrid[row-1][column] == 0) {
                dp(row-1, column, obstacleGrid)
            } else 0
            val columnPart = if (column > 0 && obstacleGrid[row][column-1] == 0) {
                dp(row, column-1, obstacleGrid)
            } else 0
            cache[row][column] = rowPart + columnPart
        }

        return cache[row][column]
    }
}