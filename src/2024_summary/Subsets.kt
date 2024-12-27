package `2024_summary`

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */

class Subsets {
    // time / space O(n x 2powN)
    fun subsets(nums: IntArray): List<List<Int>> {
        val output = mutableListOf<List<Int>>()

        fun backtrack(start: Int, currentList: MutableList<Int>) {
            output.add(currentList.toList())

            for (i in start until nums.size) {
                currentList.add(nums[i])
                backtrack(i + 1, currentList)
                currentList.removeAt(currentList.lastIndex)
            }
        }

        backtrack(0, mutableListOf())
        return output.toList()
    }
}