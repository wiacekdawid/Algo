package dp.patterns.pathsinmatrix

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */

class MinimumFallingPathSum {
    /**
     * bottom up space/time complexity O(m*x)
     */
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val dp = Array(size = matrix.size) { IntArray(size = matrix.first().size) }

        for (row in matrix.indices) {
            for (column in 0 until matrix.first().size) {
                if (row == 0) {
                    dp[row][column] = matrix[row][column]
                } else {

                    val columnValue1 = if (column > 0) {
                        dp[row-1][column-1]
                    } else Int.MAX_VALUE
                    val columnValue2 = if (column < matrix.first().size-1) {
                        dp[row][column+1]
                    } else Int.MAX_VALUE
                    dp[row][column] = matrix[row][column] + dp[row][column+1].coerceAtMost(columnValue1.coerceAtMost(columnValue2))
                }
            }
        }

        var result = Int.MAX_VALUE
        for (column in matrix.first().indices) {
            result = result.coerceAtMost(dp.last()[column])
        }
        return result
    }
}