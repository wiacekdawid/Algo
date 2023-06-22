package `75plan`.hashmapset

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */

class DetermineIfTwo0fStringsAreClose {
    // space O(1) - because max of chars is 26 possibilities / time O(n)
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val map1 = HashMap<Char, Int>()
        val map2 = HashMap<Char, Int>()

        word1.forEach {
            map1[it] = map1.getOrDefault(it, 0) + 1
        }

        word2.forEach {
            map2[it] = map2.getOrDefault(it, 0) + 1
        }

        if (map1.keys != map2.keys) return false

        val set1 = map1.values.sorted()
        val set2 = map2.values.sorted()

        return set1 == set2
    }
}