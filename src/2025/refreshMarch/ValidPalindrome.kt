package `2025`.refreshMarch

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
// time O(n) / space O(1)
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            while (left < right && !s[left].isLetterOrDigit()) left++  // Skip non-alphanumeric
            while (left < right && !s[right].isLetterOrDigit()) right--  // Skip non-alphanumeric

            if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false

            left++
            right--
        }
        return true
    }
}