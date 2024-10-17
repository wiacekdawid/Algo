package `2024_planned`.arrayStringsHashTables

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

// time O((n - m)m) / space O(1)
class FindTheIndexOfTheFirstOccurrenceInAString {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0 // If needle is empty, return 0 by definition.
        if (haystack.length < needle.length) return -1 // If haystack is shorter, return -1.

        haystack.forEachIndexed { index, _ ->
            // Check if there are enough characters left to match the needle
            if (index + needle.length <= haystack.length) {
                if (haystack.substring(index, index + needle.length) == needle) {
                    return index
                }
            }
        }

        return -1
    }
}