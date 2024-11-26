package `2024_planned`.graphs

import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */

// time / space (n pow2)
class ShortestPathInBinaryMatrix {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0][0] == 1 || grid[grid.size - 1][grid.size - 1] == 1) {
            return -1 // No path possible if start or end is blocked
        }

        val directions = listOf(
            Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
            Pair(0, 1), Pair(1, 1), Pair(1, 0),
            Pair(1, -1), Pair(0, -1)
        )

        val n = grid.size
        val visited = Array(n) { BooleanArray(n) }
        val queue = LinkedList<Triple<Int, Int, Int>>() // (row, col, pathLength)

        // Start BFS from the top-left corner
        queue.add(Triple(0, 0, 1))
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val (x, y, pathLength) = queue.poll()

            // If we reach the bottom-right corner, return the path length
            if (x == n - 1 && y == n - 1) {
                return pathLength
            }

            for ((dx, dy) in directions) {
                val newX = x + dx
                val newY = y + dy

                if (newX in 0 until n && newY in 0 until n && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.add(Triple(newX, newY, pathLength + 1))
                    visited[newX][newY] = true // Mark as visited immediately
                }
            }
        }

        return -1 // No path found
    }
}