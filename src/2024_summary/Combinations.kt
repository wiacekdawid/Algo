package `2024_summary`

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 */

class Combinations {
    // time O(k x (n/k)) / space O(k + (n/k))
    fun combine(n: Int, k: Int): List<List<Int>> {
        val output = mutableListOf<List<Int>>()

        fun backtrack(currentNumber: Int, currentList: MutableList<Int>) {
            if (currentList.size == k) {
                output.add(currentList.toList())
                return
            }
            for (i in currentNumber until n+1) {
                currentList.add(i)
                backtrack(i+1, currentList)
                currentList.removeAt(currentList.lastIndex)
            }
        }

        backtrack(1, mutableListOf())
        return output.toList()
    }
}