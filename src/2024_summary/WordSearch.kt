package `2024_summary`

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
class WordSearch {
    // time O(m x n x 4powL) where L is length of word / space O(m x n + L)
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (word.isEmpty()) return true
        if (board.isEmpty() || board.first().isEmpty()) return false

        val rows = board.size
        val cols = board.first().size
        val visited = Array(rows) { BooleanArray(cols) }

        fun backtrack(currentIndex: Int, x: Int, y: Int): Boolean {
            // Base case: all characters in the word are matched
            if (currentIndex == word.length) return true

            // Boundary checks and validation
            if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || board[x][y] != word[currentIndex]) {
                return false
            }

            // Mark the cell as visited
            visited[x][y] = true

            // Explore all four directions
            val result = backtrack(currentIndex + 1, x - 1, y) || // Up
                    backtrack(currentIndex + 1, x + 1, y) || // Down
                    backtrack(currentIndex + 1, x, y - 1) || // Left
                    backtrack(currentIndex + 1, x, y + 1)    // Right

            // Backtrack: unmark the cell
            visited[x][y] = false
            return result
        }

        // Start backtracking from every cell in the board
        for (x in 0 until rows) {
            for (y in 0 until cols) {
                if (backtrack(0, x, y)) {
                    return true
                }
            }
        }

        return false
    }
}