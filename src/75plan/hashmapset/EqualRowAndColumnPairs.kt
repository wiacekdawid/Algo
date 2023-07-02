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

    // solutios using Trie
    fun equalPairs2(grid: Array<IntArray>): Int {
        val myTrie = Trie()
        var count = 0

        grid.forEach {
            myTrie.insert(it)
        }

        for (i in grid.indices) {
            val row = IntArray(grid.size)
            for (j in grid.first().indices) {
                row[j] = grid[j][i]
            }
            count += myTrie.search(row);
        }

        return count
    }

    internal class TrieNode {
        var count = 0
        var children: HashMap<Int, TrieNode> = HashMap()
    }

    internal class Trie(private val trie: TrieNode = TrieNode()) {

        fun insert(array: IntArray) {
//            var myTrie = this.trie
            array.forEach {
                if (!trie.children.containsKey(it)) {
                    trie.children[it] = TrieNode()
                }
//                myTrie = myTrie.children[it] ?: TrieNode()
            }
            trie.count += 1
        }

        fun search(array: IntArray): Int {
            var myTrie = trie
            array.forEach {
                if (myTrie.children.containsKey(it)) {
                    myTrie = myTrie.children[it] ?: TrieNode()
                } else {
                    return 0
                }
            }
            return myTrie.count
        }
    }
}