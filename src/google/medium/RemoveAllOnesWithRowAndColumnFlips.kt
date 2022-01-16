package google.medium

/**
 * You are given an m x n binary matrix grid.
 * In one operation, you can choose any row or column and flip each value in that row or column
 * (i.e., changing all 0's to 1's, and all 1's to 0's).
 * Return true if it is possible to remove all 1's from grid using any number of operations
 * or false otherwise.
 * time O(m*n) / space O(1)
 */

fun main() {
    val test = RemoveAllOnesWithRowAndColumnFlips()
        .removeOnes(arrayOf(intArrayOf(0,1,0), intArrayOf(1,0,1), intArrayOf(0,1,0)))
}
class RemoveAllOnesWithRowAndColumnFlips {
    fun removeOnes(grid: Array<IntArray>): Boolean {
        // loop through all columns in the first row. if its value
        // is 1, then flip all the values in that column:
        for (i in grid[0].indices) {
            if (grid[0][i] == 1) {
                for (j in grid.indices) {
                    grid[j][i] = (grid[j][i]+1) % 2
                }
            }
        }


        // after doing this procedure, each row should be
        // [0,0,....0] or [1,1,1,....1]. so len(set(row)) should be
        // equal to 1. if it's 2, then return False:
        val set = mutableSetOf<Int>()

        for (i in grid.indices) {
            set.clear()
            for (j in grid[0].indices) {
                set.add(grid[i][j])
            }
            if (set.size > 1)
                return false
        }
        return true
    }
}