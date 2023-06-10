package `75plan`.slidingwindow

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */

class MaximumNumberOfVowelsinaSubstringofGivenLength {
    // time O(n) / space O(1)
    fun maxVowels(s: String, k: Int): Int {
        if (s.length < k) {
            return 0
        }
        var maxVowels = 0

        for (i in 0 until k) {
            if (isVowel(s[i])) {
                maxVowels++
            }
        }

        var currentMax = maxVowels
        var minIndex = 1

        for (maxIndex in k until s.length) {
            if (isVowel(s[minIndex-1])) {
                currentMax--
            }
            if (isVowel(s[maxIndex])) {
                currentMax++
            }
            minIndex++
            maxVowels = maxVowels.coerceAtLeast(currentMax)
        }
        return maxVowels
    }

    private fun isVowel(c: Char) =
        c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}