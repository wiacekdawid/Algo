package `2024_backtracking`

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */

class Subsets {
    // Backtracking time O(n*2powN) / space O(n*2powN)
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(start: Int, current: MutableList<Int>) {
            // Add the current subset to the result
            result.add(current.toList())

            // Explore further subsets
            for (i in start until nums.size) {
                // Include nums[i] in the current subset
                current.add(nums[i])

                // Recurse to build subsets including nums[i]
                backtrack(i + 1, current)

                // Backtrack: remove nums[i] and explore other possibilities
                current.removeAt(current.lastIndex)
            }
        }

        // Start the backtracking process
        backtrack(0, mutableListOf())
        return result
    }

    // time O(2powN) / space O(2powN)
    fun subsets2(nums: IntArray): List<List<Int>> {
        val output = mutableListOf<List<Int>>()
        output.add(emptyList())

        nums.forEach { num ->
            val newSubsets = mutableListOf<List<Int>>()
            output.forEach { currentList ->
                newSubsets.add(currentList + num)
            }
            output.addAll(newSubsets)
        }

        return output
    }
}