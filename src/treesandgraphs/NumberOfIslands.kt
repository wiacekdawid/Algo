package treesandgraphs

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * time / space O(rows x columns)
 */

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        var numOfIsland = 0
        var visited = Array(grid.size) { BooleanArray(grid[0].size) }

        for(indexX in grid.indices) {
            for (indexY in grid[0].indices) {
                if (grid[indexX][indexY] == '1' && !visited[indexX][indexY]) {
                    numOfIsland++
                    dfs(grid, visited, indexX, indexY)
                }
            }
        }
        return numOfIsland
    }

    private fun dfs(grid: Array<CharArray>, visited: Array<BooleanArray>, indexX: Int, indexY: Int) {
        if (indexX < 0 || indexX >= grid.size || indexY < 0 || indexY >= grid[0].size || grid[indexX][indexY] != '1' || visited[indexX][indexY])
            return
        else {
            visited[indexX][indexY] = true
            dfs(grid, visited, indexX+1, indexY)
            dfs(grid, visited, indexX-1, indexY)
            dfs(grid, visited, indexX, indexY+1)
            dfs(grid, visited, indexX, indexY-1)
        }
    }
}