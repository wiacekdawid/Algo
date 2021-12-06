package arraysandstrings

import java.util.*
import kotlin.collections.HashSet

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val localNums = nums
        Arrays.sort(localNums)
        val result = mutableListOf<List<Int>>()
        localNums.forEachIndexed { index, i ->
            if (localNums[index] <= 0 && (index == 0 || localNums[index-1] != localNums[index])) {
                twoSum(localNums, index, result)
            }
        }
        return result
    }
    private fun twoSum(nums:IntArray,
                       targetIndex: Int,
                       result: MutableList<List<Int>>) {
        val set = HashSet<Int>()
        var index = targetIndex+1
        while(index < nums.size) {
            val complement = -nums[targetIndex]-nums[index]
            if (set.contains(complement)) {
                result.add(listOf(nums[targetIndex], nums[index], complement))
                while (index < nums.size-1 && nums[index] == nums[index+1])
                    index++
            }
            set.add(nums[index])
            index++
        }
    }
}