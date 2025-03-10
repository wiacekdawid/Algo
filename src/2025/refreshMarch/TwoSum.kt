package `2025`.refreshMarch

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

// time space O(n)
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val complementMap = HashMap<Int, Int>()

        nums.forEachIndexed { index, i ->
            val current = target - i
            if (complementMap.containsKey(current)) {
                return intArrayOf(complementMap.getValue(current), index)
            } else {
                complementMap[i] = index
            }
        }
        throw IllegalStateException("No 2 sum found in given array")
    }
}