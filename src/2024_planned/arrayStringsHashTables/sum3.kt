package `2024_planned`.arrayStringsHashTables

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */

// time / space O(npow2)
class sum3 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableSetOf<List<Int>>()

        for (index in 0 until nums.size - 2) {
            if (index > 0 && nums[index] == nums[index - 1]) continue // Skip duplicates

            var leftIndex = index + 1
            var rightIndex = nums.size - 1

            while (leftIndex < rightIndex) {
                val sum = nums[index] + nums[leftIndex] + nums[rightIndex]

                when {
                    sum == 0 -> {
                        result.add(listOf(nums[index], nums[leftIndex], nums[rightIndex]))
                        leftIndex++
                        rightIndex--
                        // Skip duplicates
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) leftIndex++
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) rightIndex--
                    }
                    sum > 0 -> rightIndex--
                    else -> leftIndex++
                }
            }
        }

        return result.toList()
    }
}