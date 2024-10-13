package `2024_planned`.arrayStringsHashTables

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

// time / space O(n)
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val setOfSeen = mutableSetOf<Int>()
        nums.forEach {
            if (setOfSeen.contains(it)) {
                return true
            }
            setOfSeen.add(it)
        }
        return false
    }
}