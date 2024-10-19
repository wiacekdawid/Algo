package `2024_planned`.hashTables

import java.util.*

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

class FirstUniqueCharacterInAString {
    // time O(n) / space O(n)
    fun firstUniqChar(s: String): Int {
        val charIndexMap = mutableMapOf<Char, Int>()
        val repeatedChars = mutableSetOf<Char>()

        s.forEachIndexed { index, c ->
            if (charIndexMap.containsKey(c)) {
                // If the character is already in the map, add it to the set of repeated characters
                repeatedChars.add(c)
            } else {
                // If the character is seen for the first time, add it to the map
                charIndexMap[c] = index
            }
        }

        // Find the first character that is in the map but not in the repeated set
        charIndexMap.forEach { (char, index) ->
            if (!repeatedChars.contains(char)) {
                return index
            }
        }

        return -1
    }

    // time O(n) / space O(1)
    fun firstUniqChar2(s: String): Int {
        val charCount = IntArray(26) // Array to store frequency of each character (assuming lowercase letters)

        // First pass: count the occurrences of each character
        for (c in s) {
            charCount[c - 'a']++
        }

        // Second pass: find the first character that occurs only once
        for (i in s.indices) {
            if (charCount[s[i] - 'a'] == 1) {
                return i
            }
        }

        return -1
    }
}