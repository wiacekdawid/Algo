package `2024_summary`

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

class FindTheIndexOfTheFirstOccurrenceInaString {
    // O((m-n+1) n) / space O(1)
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0 // Handle edge case for empty needle
        if (needle.length > haystack.length) return -1 // Handle edge case for needle longer than haystack

        for (i in 0..haystack.length - needle.length) {
            var j = 0
            while (j < needle.length && haystack[i + j] == needle[j]) {
                j++
            }
            if (j == needle.length) {
                return i
            }
        }

        return -1
    }
}