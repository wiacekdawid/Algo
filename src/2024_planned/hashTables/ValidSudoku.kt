package `2024_planned`.hashTables

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */

// time O(n) / space O(1)
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { mutableSetOf<Char>() }
        val columns = Array(9) { mutableSetOf<Char>() }
        val subboxes = Array(9) { mutableSetOf<Char>() }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val char = board[i][j]

                if (char == '.') continue

                if (rows[i].contains(char)) return false else rows[i].add(char)
                if (columns[j].contains(char)) return false else columns[j].add(char)
                val boxIndex = (i / 3) * 3 + (j / 3)
                if (subboxes[boxIndex].contains(char)) return false else subboxes[boxIndex].add(char)
            }
        }

        return true
    }
}