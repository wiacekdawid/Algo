package `2025`.g.treesgraphs

import java.util.ArrayDeque

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 */
class DecodeString {
    // time O(n) / space O(d+m) where d depth of storage brackets / m output size
    fun decodeString(s: String): String {
        val countStack = ArrayDeque<Int>()
        val stringStack = ArrayDeque<StringBuilder>()
        var currentString = StringBuilder()
        var currentNumber = 0

        for (char in s) {
            when {
                char.isDigit() -> {
                    currentNumber = currentNumber * 10 + (char - '0') // Extract full number
                }
                char == '[' -> {
                    countStack.addLast(currentNumber) // Push count
                    stringStack.addLast(currentString) // Push current string
                    currentString = StringBuilder() // Reset current string
                    currentNumber = 0 // Reset number
                }
                char == ']' -> {
                    val repeatTimes = countStack.removeLast() // Get repeat count
                    val lastString = stringStack.removeLast() // Get last stored string
                    repeat(repeatTimes) {
                        lastString.append(currentString)
                    }
                    currentString = lastString // Restore the expanded string
                }
                else -> {
                    currentString.append(char) // Normal character
                }
            }
        }
        return currentString.toString()
    }
}