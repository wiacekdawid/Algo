package google.hard

import java.util.*

/**
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle).
 * You can move up, down, left, or right from and to an empty cell in one step.
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner
 * (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 * BFS time/space O(n*k) where n is num of cells and k is num passed to the function
 */

fun main() {
    ShortestPathinaGridwithObstaclesElimination()
        .shortestPath(arrayOf(intArrayOf(0,0,0),intArrayOf(1,1,0),intArrayOf(0,0,0),intArrayOf(0,1,1),intArrayOf(0,0,0)),1)
}

class ShortestPathinaGridwithObstaclesElimination {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val rows = grid.size
        val columns = grid[0].size
        val target = intArrayOf(rows-1, columns-1)

        // if we can eliminate more than this the shortest distance will be Manhattan distance
        if (k >= (rows+columns-1))
            return rows+columns-2

        val queue = LinkedList<Step>()
        val seenSteps = mutableSetOf<Step>()
        val firstStep = Step(0, 0, 0, k)
        queue.add(firstStep)
        seenSteps.add(firstStep)
        while (queue.isNotEmpty()) {
            val currentStep = queue.poll()

            if (currentStep.row == target[0] && currentStep.col == target[1])
                return currentStep.steps


            val nextSteps = intArrayOf(
                currentStep.row, currentStep.col + 1, currentStep.row + 1, currentStep.col,
                currentStep.row, currentStep.col - 1, currentStep.row - 1, currentStep.col
            )

            // explore the four directions in the next step
            for (i in 0 until nextSteps.size step 2) {
                val nextRow = nextSteps.get(i)
                val nextCol = nextSteps.get(i + 1)

                // out of the boundary of grid
                if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == columns) {
                    continue
                }
                val nextElimination = currentStep.k - grid[nextRow][nextCol]
                val newState = Step(currentStep.steps + 1, nextRow, nextCol, nextElimination)

                // add the next move in the queue if it qualifies.
                if (nextElimination >= 0 && !seenSteps.contains(newState)) {
                    seenSteps.add(newState)
                    queue.addLast(newState)
                }
            }
        }
        return -1
    }

    data class Step(val steps: Int, val row: Int, val col: Int, val k: Int)
}