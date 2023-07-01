package `75plan`.hashmapset


/**
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */
fun main() {
    val test = EqualRowAndColumnPairs().equalPairs(arrayOf(intArrayOf(3,2,1),intArrayOf(1,7,6),intArrayOf(2,7,7)))
}
class EqualRowAndColumnPairs {
    // time/space O(n * pow2)
    fun equalPairs(grid: Array<IntArray>): Int {
        var result = 0
        val mapOfCol = HashMap<String, Int>()

        grid.forEachIndexed { index, ints ->
            mapOfCol[ints.contentToString()] = mapOfCol.getOrDefault(ints.contentToString(), 0) + 1
        }

        for (i in grid.indices) {
            val row = IntArray(grid.size)
            for (j in grid.first().indices) {
                row[j] = grid[j][i]
            }
            if (mapOfCol.containsKey(row.contentToString())) {
                result += mapOfCol.getOrDefault(row.contentToString(), 0)
            }
        }
        return result
    }

    internal class TrieNode {
        var count = 0
        var children: Map<Int, TrieNode> = HashMap()
    }

    internal class Trie(trie: TrieNode = TrieNode()) {
        fun insert(array: IntArray) {

        }
    }
}