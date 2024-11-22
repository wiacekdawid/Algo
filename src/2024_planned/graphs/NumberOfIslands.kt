package `2024_planned`.graphs

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

// time O(m x n) / space O(min(m,n)) - recursion stack
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        var numOfIslands = 0

        for (x in grid.indices) {
            for (y in grid[0].indices) {
                if (grid[x][y] == '1') {
                    numOfIslands++
                    exploreCurrent(x, y, grid)
                }
            }
        }

        return numOfIslands
    }

    private fun exploreCurrent(x: Int, y: Int, grid: Array<CharArray>) {
        // Check boundaries and stop if the cell is not part of an island
        if (x < 0 || y < 0 || x >= grid.size || y >= grid[0].size || grid[x][y] == '0') {
            return
        }

        // Mark the cell as visited
        grid[x][y] = '0'

        // Explore all 4 directions
        exploreCurrent(x - 1, y, grid) // Up
        exploreCurrent(x + 1, y, grid) // Down
        exploreCurrent(x, y - 1, grid) // Left
        exploreCurrent(x, y + 1, grid) // Right
    }
}