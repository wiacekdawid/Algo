package `2024_summary`

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val output = mutableListOf<List<Int>>()

        fun backtrack(currentIndex, currentList: MutableList) {
            if (currentIndex == nums.size) {
                output.add(currentList.toList())
            }

            for (i in currentIndex until nums.size) {
                currentList.add(nums[1])
                backtrack(i, currentList)
                currentList.removeAt(currentList.lastIndex)
            }
        }

        backtrack(0, mutableListOf<Int>())
        return output.toList()
    }
}