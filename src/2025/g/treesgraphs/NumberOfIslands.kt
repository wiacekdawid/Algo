package `2025`.g.treesgraphs

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
class NumberOfIslands {
    // time / space O(m x n)
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        var numOfIslands = 0
        val rows = grid.size
        val cols = grid[0].size

        fun exploreCurrentIsland(x: Int, y: Int) {
            if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != '1') return
            grid[x][y] = '.'
            exploreCurrentIsland(x - 1, y)
            exploreCurrentIsland(x + 1, y)
            exploreCurrentIsland(x, y - 1)
            exploreCurrentIsland(x, y + 1)
        }

        for (x in grid.indices) {
            for (y in grid[x].indices) {
                if (grid[x][y] == '1') {
                    numOfIslands++
                    exploreCurrentIsland(x, y)
                }
            }
        }

        return numOfIslands
    }
}