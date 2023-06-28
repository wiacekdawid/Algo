package `75plan`.hashmapset

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */
fun main() {
    val test = EqualRowAndColumnPairs().equalPairs(arrayOf(intArrayOf(3,2,1),intArrayOf(1,7,6),intArrayOf(2,7,7)))
}
class EqualRowAndColumnPairs {
    // time O(n) space O(n)
    fun equalPairs(grid: Array<IntArray>): Int {
        val result = ArrayList<IntArray>()
        val mapOfCol = HashMap<String, Int>()

        grid.forEachIndexed { index, ints ->
            mapOfCol[ints.contentToString()] = index
        }

        for (i in grid.indices) {
            val row = IntArray(grid.size)
            for (j in grid.first().indices) {
                row[j] = grid[j][i]
            }
            if (mapOfCol.containsKey(row.contentToString())) {
                result.add(row)
            }
        }
        return result.size
    }
}