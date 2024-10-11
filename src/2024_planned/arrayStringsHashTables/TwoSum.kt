package `2024_planned`.arrayStringsHashTables

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
// time space O(n)
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = HashMap<Int, Int>()

        nums.forEachIndexed { index, i ->
            val complement = target - i
            if (seen.containsKey(complement)) {
                return intArrayOf(seen[complement]!!, index)
            }
            seen[i] = index
        }

        return intArrayOf()
    }
}