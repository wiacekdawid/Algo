package `2025`.g.sortandsearch

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */

class ValidAnagram {
    // time O(n) / space O(1)
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val frequencyMap = mutableMapOf<Char, Int>()

        s.forEach { char ->
            frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1
        }

        t.forEach { char ->
            val count = frequencyMap.getOrDefault(char, 0)
            if (count == 0) return false
            frequencyMap[char] = count - 1
        }

        return true
    }
}