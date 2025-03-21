package `2025`.refreshMarch

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */

// time / space O(n)
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        if (s.isEmpty() && t.isEmpty()) return true
        val frequencyMap = HashMap<Char, Int>()
        s.forEach {
            frequencyMap[it] = frequencyMap.getOrDefault(it, 0) + 1
        }

        t.forEach {
            if (frequencyMap.containsKey(it)) {
                frequencyMap[it] = frequencyMap.getOrDefault(it, 1) - 1
                if (frequencyMap[it] == 0) frequencyMap.remove(it)
            } else {
                return false
            }
        }
        return frequencyMap.isEmpty()
    }
}