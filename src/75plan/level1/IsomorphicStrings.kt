package `75plan`.level1

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
class IsomorphicStrings {
    // time/ space O(max(s,t))
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val mapOfChar1 = mutableMapOf<Char, Char>()
        val mapOfChar2 = mutableMapOf<Char, Char>()

        s.forEachIndexed { index, c ->
            if (mapOfChar1.containsKey(c)) {
                if (mapOfChar1[c] != t[index]) return false
            } else {
                mapOfChar1[c] = t[index]
            }
        }

        t.forEachIndexed { index, c ->
            if (mapOfChar2.containsKey(c)) {
                if (mapOfChar2[c] != s[index]) return false
            } else {
                mapOfChar2[c] = s[index]
            }
        }
        return true
    }
}