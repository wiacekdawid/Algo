package dp.patterns.statereduction

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters
 * using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 *
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * Given a string s containing only digits, return the number of ways to decode it.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */

fun main() {
    val test = DecodeWays().numDecodings("12")
    val test1 = test
}
class DecodeWays {
    // top down
    private lateinit var cache: IntArray
    fun numDecodings(s: String): Int {
        cache = IntArray(s.length+1) { -1 }
        return dp(s, s.length)
    }

    private fun dp(s: String, index: Int): Int {
        if (index <= 0) {
            return 0
        }
        if (cache[index] == -1) {
            if (index == 1) {
                cache[1] = if (isInDict(s.substring(0, 1))) 1 else -1
            } else {
                val takeTwo = isInDict(s.substring(index - 2, index))
                val takeOne = isInDict(s.substring(index - 1, index))
                if (takeOne || takeTwo) {
                    val goOne = if (takeOne) { dp(s, index-1) } else 0
                    val goTwo = if (takeTwo) { dp(s, index-2) } else 0

                    if (goOne < 0 && goTwo < 0) {
                        cache[index] = -2
                    } else {
                        cache[index] = if (goOne > 0 && goTwo > 0) { 1 + goOne + goTwo } else { goOne + goTwo}
                    }
                }
            }
        }

        return cache[index]
    }

    private fun isInDict(s: String): Boolean = s.toInt() in 1..26
}