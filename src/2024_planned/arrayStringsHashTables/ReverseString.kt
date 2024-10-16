package `2024_planned`.arrayStringsHashTables

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */

// time O(n) / space O(1)
class ReverseString {
    fun reverseString(s: CharArray): Unit {
        if (s.size < 2) return
        var leftIndex = 0
        var rightIndex = s.size-1
        while (leftIndex < rightIndex) {
            val temp = s[leftIndex]
            s[leftIndex++] = s[rightIndex]
            s[rightIndex--] = temp
        }
    }
}