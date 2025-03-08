package `2025`.refreshMarch

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

// time / space O(n)
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val seenInt = HashSet<Int>()  // Using HashSet directly for efficiency
        for (num in nums) {
            if (!seenInt.add(num)) return true  // `add()` returns false if element already exists
        }
        return false
    }
}