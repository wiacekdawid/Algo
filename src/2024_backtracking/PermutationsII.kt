package `2024_backtracking`

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */

class PermutationsII {
    // time O(n * n!) / space O(n)
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort() // Sort to ensure duplicates are adjacent
        val used = BooleanArray(nums.size)

        fun backtrack(current: MutableList<Int>) {
            // Base case: If the current list contains all numbers, it's a valid permutation
            if (current.size == nums.size) {
                result.add(current.toList())
                return
            }

            for (i in nums.indices) {
                // Skip already used numbers
                if (used[i]) continue

                // Skip duplicates (only allow the first occurrence in this recursion level)
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue

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