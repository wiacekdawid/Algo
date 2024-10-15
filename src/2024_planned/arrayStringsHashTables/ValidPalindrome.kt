package `2024_planned`.arrayStringsHashTables

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
// time complexity O(n) / space O(1)
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        if (s.length < 2) return true
        var leftIndex = 0
        var rightIndex = s.length-1

        while (leftIndex < rightIndex) {
            if (!s[leftIndex].isLetterOrDigit()) {
                leftIndex++
            } else if (!s[rightIndex].isLetterOrDigit()) {
                rightIndex--
            } else if (s[leftIndex].equals(s[rightIndex], ignoreCase = true)) {
                leftIndex++
                rightIndex--
            } else {
                return false
            }
        }

        return true
    }
}