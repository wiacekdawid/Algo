package dp.patterns.pathsinmatrix

/**
 * There is a robot on an m x n grid.
 * The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
class UniquePaths {

    /**
     * bottom up space/time complexity O(m*x)
     */
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(size = m) { IntArray(size = n) }
        dp[0][0] = 1

        for (row in 0 until m) {
            for (column in 0 until n) {
                if (row > 0) {
                    dp[row][column] += dp[row-1][column]
                }
                if (column > 0) {
                    dp[row][column] += dp[row][column-1]
                }
            }
        }
        return dp[m-1][n-1]
    }
}