package `2024_planned`.hashTables

import java.util.*

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

// time / space O(n)
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val seenChars = mutableSetOf<Char>()  // Store characters in current window
        var maxLength = 0
        var start = 0

        for (end in s.indices) {
            val currentChar = s[end]

            // Shrink the window if the current character is already in the set
            while (seenChars.contains(currentChar)) {
                seenChars.remove(s[start])
                start++
            }

            // Add the current character to the set and update the max length
            seenChars.add(currentChar)
            maxLength = maxLength.coerceAtLeast(end - start + 1)
        }

        return maxLength
    }
}