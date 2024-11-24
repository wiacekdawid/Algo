package `2024_planned`.graphs

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height.
 * Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */

// time / space O(m x n)
class PacificAtlanticWaterFlow {
    @OptIn(ExperimentalStdlibApi::class)
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        if (heights.isEmpty()) return emptyList()

        val rows = heights.size
        val cols = heights[0].size
        val pacific = Array(rows) { BooleanArray(cols) }
        val atlantic = Array(rows) { BooleanArray(cols) }

        val directions = arrayOf(
            Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1) // Up, Down, Left, Right
        )

        fun bfs(queue: ArrayDeque<Pair<Int, Int>>, reachable: Array<BooleanArray>) {
            while (queue.isNotEmpty()) {
                val (i, j) = queue.removeFirst()

                for ((di, dj) in directions) {
                    val ni = i + di
                    val nj = j + dj

                    if (ni in 0 until rows && nj in 0 until cols &&
                        !reachable[ni][nj] &&
                        heights[ni][nj] >= heights[i][j] // Flow condition
                    ) {
                        reachable[ni][nj] = true
                        queue.add(Pair(ni, nj))
                    }
                }
            }
        }

        // Initialize BFS queues
        val pacificQueue = ArrayDeque<Pair<Int, Int>>()
        val atlanticQueue = ArrayDeque<Pair<Int, Int>>()

        for (i in 0 until rows) {
            pacificQueue.add(Pair(i, 0)) // Left column (Pacific)
            atlanticQueue.add(Pair(i, cols - 1)) // Right column (Atlantic)
            pacific[i][0] = true
            atlantic[i][cols - 1] = true
        }

        for (j in 0 until cols) {
            pacificQueue.add(Pair(0, j)) // Top row (Pacific)
            atlanticQueue.add(Pair(rows - 1, j)) // Bottom row (Atlantic)
            pacific[0][j] = true
            atlantic[rows - 1][j] = true
        }

        // Perform BFS for both oceans
        bfs(pacificQueue, pacific)
        bfs(atlanticQueue, atlantic)

        // Find all cells reachable by both oceans
        val result = mutableListOf<List<Int>>()
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }

}