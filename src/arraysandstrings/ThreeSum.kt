package arraysandstrings

import java.util.*
import kotlin.collections.HashSet

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * time o(n2) space o(n)
 */

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        Arrays.sort(nums)
        val result = mutableListOf<List<Int>>()
        nums.forEachIndexed { index, i ->
            if (nums[index] <= 0 && (index == 0 || nums[index-1] != nums[index])) {
                twoSum(nums, index, result)
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