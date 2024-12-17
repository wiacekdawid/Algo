package `2024_backtracking`

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

class Permutations {
    // time O(n * n!) / space O(n)
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val used = BooleanArray(nums.size) // Track used numbers

        fun backtrack(current: MutableList<Int>) {
            // Base case: If the current list contains all numbers, it's a valid permutation
            if (current.size == nums.size) {
                result.add(current.toList()) // Add a copy of the current list
                return
            }

            // Recursive case: Try all unused numbers
            for (i in nums.indices) {
                if (used[i]) continue // Skip numbers that are already used

                // Choose the current number
                current.add(nums[i])
                used[i] = true

                // Recurse to build the next part of the permutation
                backtrack(current)

                // Backtrack: Undo the last choice
                current.removeAt(current.size - 1)
                used[i] = false
            }
        }

        backtrack(mutableListOf())
        return result
    }
}