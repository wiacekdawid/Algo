package `75plan`.level1.arraystrings

/**
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 */
class StringCompression {
    fun compress(chars: CharArray): Int {
        var result = 0
        var currentChar = ' '
        var currentLength = 0
        var newArrayPosition = 0
        chars.forEachIndexed { index, c ->
            if (c != currentChar || index == chars.size-1) {
                if (currentLength == 1) {
                    result++
                } else if (currentLength > 1) {
                    result += 1 + numberOfDigits(currentLength)
                }
                currentLength = 1
                currentChar = c
            } else {
                currentLength++
            }
        }
        return result
    }

    private fun numberOfDigits(n: Int): Int =
        when (n) {
            in -9..9 -> 1
            else -> 1 + numberOfDigits(n / 10)
        }
}