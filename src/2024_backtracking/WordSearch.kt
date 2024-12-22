package `2024_backtracking`

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */

class WordSearch {
    // time O(MxNx4powL) M-rows L-columns L-word length / space O(MxN+L) so O(MxN)
    fun exist(board: Array<CharArray>, word: String): Boolean {

        if (board.isEmpty()) return word.isEmpty()

        fun backtrack(currentRow: Int, currentCol: Int, currentWordIndex: Int, used: Array<BooleanArray>): Boolean {
            if (currentWordIndex == word.length) return true

            // Check boundaries
            if (currentRow < 0 || currentRow >= board.size || currentCol < 0 || currentCol >= board[0].size) {
                return false
            }

            // Check if the current cell matches the word and hasn't been used
            if (used[currentRow][currentCol] || board[currentRow][currentCol] != word[currentWordIndex]) {
                return false
            }

            // Mark the cell as used
            used[currentRow][currentCol] = true

            // Explore neighbors
            val result = backtrack(currentRow + 1, currentCol, currentWordIndex + 1, used) ||
                    backtrack(currentRow - 1, currentCol, currentWordIndex + 1, used) ||
                    backtrack(currentRow, currentCol + 1, currentWordIndex + 1, used) ||
                    backtrack(currentRow, currentCol - 1, currentWordIndex + 1, used)

            // Backtrack: Reset the cell as unused
            used[currentRow][currentCol] = false

            return result
        }

        for (row in board.indices) {
            for (col in board[0].indices) {
                if (backtrack(row, col, 0, Array(board.size) { BooleanArray(board[0].size) })) {
                    return true
                }
            }
        }

        return false
    }
}