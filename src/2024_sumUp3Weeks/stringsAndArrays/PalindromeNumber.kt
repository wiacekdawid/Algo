package `2024_sumUp3Weeks`.stringsAndArrays

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */

class PalindromeNumber {
    // time / space O(n)
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x < 10) return true
        val charArray = x.toString().toCharArray()
        var pointerL = 0
        var pointerR = charArray.size-1

        while (pointerL < pointerR) {
            if (charArray[pointerL++] != charArray[pointerR--])
                return false
        }

        return true
    }

    // time O(n) / space O(1)
    fun isPalindrome2(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false // Handle negatives and multiples of 10
        var original = x
        var reversed = 0

        while (original > reversed) {
            reversed = reversed * 10 + original % 10
            original /= 10
        }

        // Check if original equals reversed for even-length numbers,
        // or if original equals reversed/10 for odd-length numbers
        return original == reversed || original == reversed / 10
    }
}