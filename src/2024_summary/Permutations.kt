package `2024_summary`

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

// time O(n x n!) / space O(n) for recursion stack
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val output = mutableListOf<List<Int>>()

        fun backtrack(start: Int) {
            if (start == nums.size) {
                output.add(nums.toList())
                return
            }

            for (i in start until nums.size) {
                // Swap elements at `start` and `i`
                nums[start] = nums[i].also { nums[i] = nums[start] }
                // Recur with the next position
                backtrack(start + 1)
                // Backtrack: undo the swap
                nums[start] = nums[i].also { nums[i] = nums[start] }
            }
        }

        backtrack(0)
        return output
    }
}