package `2024_planned`.arrayStringsHashTables

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */

// time O(n) / space O(1)
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val mapOfLetters = mutableMapOf<Char, Int>()

        // Count characters in the first string
        s.forEach { char ->
            mapOfLetters[char] = mapOfLetters.getOrDefault(char, 0) + 1
        }

        // Decrease count based on characters in the second string
        t.forEach { char ->
            val count = mapOfLetters.getOrDefault(char, 0) - 1
            if (count < 0) {
                return false // More occurrences in `t` than in `s`
            }
            mapOfLetters[char] = count
        }

        // Check if all counts are zero (all characters matched)
        return mapOfLetters.values.all { it == 0 }
    }
}