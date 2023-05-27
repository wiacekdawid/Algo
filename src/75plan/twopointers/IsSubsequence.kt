package `75plan`.twopointers

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
 * characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
class IsSubsequence {
    // time O(n) space O(1)
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) {
            return false
        }
        var pointerLonger = 0
        var pointerShorter = 0

        if (s.isEmpty()) return true
        while (pointerLonger < t.length) {
            if (pointerShorter < s.length && t[pointerLonger] == s[pointerShorter]) {
                pointerShorter++
            }
            if (pointerShorter == s.length) {
                return true
            }
            pointerLonger++
        }

        return false
    }
}