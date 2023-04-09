package `75plan`.level1

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

class IsSubsequence {
    // time O(t.length) / space O(1)
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) {
            return false
        }

        var currentIndexInT = 0

        t.forEach {
            if (currentIndexInT >= s.length)
                return currentIndexInT == s.length
            if (s[currentIndexInT] == it) {
                currentIndexInT++
            }
        }

        return currentIndexInT == s.length
    }
}