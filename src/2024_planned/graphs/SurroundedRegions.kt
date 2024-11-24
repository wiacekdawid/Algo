package `2024_planned`.graphs

import java.util.ArrayDeque

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
 */

// time / space O(mxn)
class SurroundedRegions {
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty()) return

        val rows = board.size
        val cols = board[0].size

        // Helper function to perform BFS and mark edge-connected regions
        fun bfsMark(i: Int, j: Int) {
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(Pair(i, j))
            board[i][j] = 'E' // Mark as edge-connected

            while (queue.isNotEmpty()) {
                val (x, y) = queue.removeFirst()
                val directions = arrayOf(
                    Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
                )

                for ((dx, dy) in directions) {
                    val newX = x + dx
                    val newY = y + dy
                    if (newX in 0 until rows && newY in 0 until cols && board[newX][newY] == 'O') {
                        board[newX][newY] = 'E' // Mark as edge-connected
                        queue.add(Pair(newX, newY))
                    }
                }
            }
        }

        // Step 1: Mark all edge-connected 'O' regions
        for (i in 0 until rows) {
            if (board[i][0] == 'O') bfsMark(i, 0)
            if (board[i][cols - 1] == 'O') bfsMark(i, cols - 1)
        }
        for (j in 0 until cols) {
            if (board[0][j] == 'O') bfsMark(0, j)
            if (board[rows - 1][j] == 'O') bfsMark(rows - 1, j)
        }

        // Step 2: Flip surrounded regions and restore edge-connected regions
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                when (board[i][j]) {
                    'O' -> board[i][j] = 'X' // Surrounded region
                    'E' -> board[i][j] = 'O' // Edge-connected region
                }
            }
        }
    }
}