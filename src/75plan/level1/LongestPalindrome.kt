package `75plan`.level1

/**
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
class LongestPalindrome {
    // time O(n) / space O(1)
    fun longestPalindrome(s: String): Int {
        val set = mutableSetOf<Char>()
        var longest = 0

        s.forEach { currentLetter ->
            if (set.contains(currentLetter)) {
                longest += 2
                set.remove(currentLetter)
            } else {
                set.add(currentLetter)
            }
        }

        if (set.isNotEmpty()) longest++
        return longest
    }
}