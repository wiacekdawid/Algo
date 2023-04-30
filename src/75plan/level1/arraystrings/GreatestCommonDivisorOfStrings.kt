package `75plan`.

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */


class GreatestCommonDivisorOfStrings {
    // time / space O(m+n)
    fun gcdOfStrings(str1: String, str2: String): String {
        if ((str1 + str2) != str2 + str1) {
            return ""
        }

        val gcdLength = gcd(str1.length, str2.length)
        return str1.substring(0, gcdLength)
    }

    private fun gcd(x: Int, y: Int): Int {
        return if (y == 0) {
            x
        } else {
            gcd(y, x % y)
        }
    }

}