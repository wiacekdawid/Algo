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
    val test = DecodeWays().numDecodings2("12")
    val test1 = test
}
class DecodeWays {
    // top down - time / space O(N)
    private lateinit var cache: IntArray
    fun numDecodings(s: String): Int {
        cache = IntArray(s.length+1) { -1 }
        return dp(s, 0)
    }

    private fun dp(s: String, index: Int): Int {
        if (index >= s.length) {
            return 1
        }

        if (s[index] == '0') {
            return 0
        }

        if (index >= s.length-1) {
            return 1
        }

        if (cache[index] == -1) {
            var result = dp(s, index + 1)
            if (s.substring(index, index + 2).toInt() <= 26) {
                result += dp(s, index + 2)
            }
            cache[index] = result
        }

        return cache[index]
    }

    // bottom up - time/space O(N)
    fun numDecodings2(s: String): Int {
        val cache = IntArray(s.length+1) { 0 }

        cache[0] = 1
        cache[1] = if (s[0] == '0') 0 else 1

        for (index in 2 until cache.size) {
            if (s[index-1] != '0') {
                cache[index] = cache[index-1]
            }

            val twoDigit = s.substring(index-2, index).toInt()
            if (twoDigit in 10..26) {
                cache[index] += cache[index-2]
            }
        }
        return cache[s.length]
    }
}