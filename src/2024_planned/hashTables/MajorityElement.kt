package `2024_planned`.hashTables

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */

class MajorityElement {
    // time / space O(n)
    fun majorityElement(nums: IntArray): Int {
        val frequency = mutableMapOf<Int, Int>()
        nums.forEach {
            frequency[it] = frequency.getOrDefault(it, 0) + 1
        }

        frequency.forEach {
            if (it.value > (nums.size/2)) {
                return it.key
            }
        }

        return -1
    }

    // Boyer Moore algorithm O(1) space complexity
    fun majorityElement2(nums: IntArray): Int {
        var candidate = nums[0]
        var count = 0

        // Phase 1: Find the majority candidate
        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            count += if (num == candidate) 1 else -1
        }

        // Phase 2: Validate that the candidate is actually the majority element
        count = 0
        for (num in nums) {
            if (num == candidate) {
                count++
            }
        }

        return if (count > nums.size / 2) candidate else -1
    }
}