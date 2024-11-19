package `2024_planned`.dp

/**
 * Given a string s, return the longest palindromic substring in s.
 */

class LongestPalindromicSubstring {
    // time O(npow2) / space O(1)
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        var start = 0
        var end = 0

        for (i in s.indices) {
            val len1 = expandAroundCenter(s, i, i)     // Odd-length palindrome
            val len2 = expandAroundCenter(s, i, i + 1) // Even-length palindrome
            val maxLen = maxOf(len1, len2)

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2
                end = i + maxLen / 2
            }
        }

        return s.substring(start, end + 1)
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1 // Length of the palindrome
    }
}