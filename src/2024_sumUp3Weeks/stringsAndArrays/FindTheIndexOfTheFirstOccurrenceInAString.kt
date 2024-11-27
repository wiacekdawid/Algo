package `2024_sumUp3Weeks`.stringsAndArrays

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

// time O((h-n) x n) / space O(1)
class FindTheIndexOfTheFirstOccurrenceInAString {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        val hLen = haystack.length
        val nLen = needle.length

        // Only loop until the point where needle can fit in haystack
        for (i in 0..hLen - nLen) {
            var found = true
            for (j in 0 until nLen) {
                if (haystack[i + j] != needle[j]) {
                    found = false
                    break
                }
            }
            if (found) return i
        }

        return -1
    }
}