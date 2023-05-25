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
    // time O(n) / space O(1)
    fun compress(chars: CharArray): Int {
        var res = 0
        var currentIndex = 0

        while (currentIndex < chars.size) {
            var groupLength = 1

            while (currentIndex + groupLength < chars.size && chars[currentIndex + groupLength] == chars[currentIndex]) {
                groupLength++
            }
            chars[res++] = chars[currentIndex]
            if (groupLength > 1) {
                groupLength.toString().toCharArray().forEach {
                    chars[res++] = it
                }
            }
            currentIndex += groupLength
        }
        return res
    }
}