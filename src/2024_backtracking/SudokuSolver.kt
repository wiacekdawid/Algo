package `2024_backtracking`

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */

// time / space O(1)
class SudokuSolver {
    fun solveSudoku(board: Array<CharArray>): Unit {
        fun isValid(board: Array<CharArray>, row: Int, col: Int, num: Char): Boolean {
            // Check the row
            for (i in 0 until 9) {
                if (board[row][i] == num) return false
            }

            // Check the column
            for (i in 0 until 9) {
                if (board[i][col] == num) return false
            }

            // Check the 3x3 sub-box
            val boxRowStart = row / 3 * 3
            val boxColStart = col / 3 * 3
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    if (board[boxRowStart + i][boxColStart + j] == num) return false
                }
            }

            return true
        }

        fun backtrack(): Boolean {
            for (row in 0 until 9) {
                for (col in 0 until 9) {
                    if (board[row][col] == '.') { // Empty cell
                        for (num in '1'..'9') {
                            if (isValid(board, row, col, num)) {
                                board[row][col] = num // Place the number
                                if (backtrack()) return true // If valid, move forward
                                board[row][col] = '.' // Backtrack
                            }
                        }
                        return false // No valid number found for this cell
                    }
                }
            }
            return true // All cells are filled
        }

        backtrack()
    }
}