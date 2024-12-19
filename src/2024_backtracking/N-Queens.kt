package `2024_backtracking`

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

// time O(n!) / space O(npow2)
class `N-Queens` {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }

        fun isSafe(row: Int, col: Int): Boolean {
            // Check column
            for (i in 0 until row) {
                if (board[i][col] == 'Q') return false
            }

            // Check diagonal (top-left to bottom-right)
            var i = row - 1
            var j = col - 1
            while (i >= 0 && j >= 0) {
                if (board[i][j] == 'Q') return false
                i--
                j--
            }

            // Check diagonal (top-right to bottom-left)
            i = row - 1
            j = col + 1
            while (i >= 0 && j < n) {
                if (board[i][j] == 'Q') return false
                i--
                j++
            }

            return true
        }

        fun backtrack(row: Int) {
            if (row == n) {
                // Convert the board to a list of strings and add to result
                result.add(board.map { it.joinToString("") })
                return
            }

            for (col in 0 until n) {
                if (isSafe(row, col)) {
                    // Place queen
                    board[row][col] = 'Q'

                    // Recurse to the next row
                    backtrack(row + 1)

                    // Backtrack: Remove the queen
                    board[row][col] = '.'
                }
            }
        }

        backtrack(0)
        return result
    }
}