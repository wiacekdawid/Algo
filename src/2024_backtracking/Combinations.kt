package `2024_backtracking`

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 */

class Combinations {
    // time O(k C(n,k))/ space O(k) where
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(start: Int, current: MutableList<Int>) {
            // Base Case: If the current combination has `k` elements, add it to the result
            if (current.size == k) {
                result.add(current.toList())
                return
            }

            // Explore candidates starting from the current index
            for (i in start..n) { // Iterate through the range [start, n]
                current.add(i) // Choose the number
                backtrack(i + 1, current) // Recurse with the next number
                current.removeAt(current.lastIndex) // Backtrack
            }
        }

        backtrack(1, mutableListOf()) // Start from 1
        return result
    }
}