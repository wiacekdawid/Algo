package arraysandstrings

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * time / space O(N)/O(1)
 */

class FirstUniqueCharacterInAString {
    fun firstUniqChar(s: String): Int {
        if (s.isEmpty()) return -1

        val count = mutableMapOf<Char, Int>()

        s.forEach {
            count[it] = count.getOrDefault(it, 0) + 1
        }

        for (i in s.indices) {
            if (count[s[i]] == 1) return i
        }
        return -1
    }
}