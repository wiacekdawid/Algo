package `2024_planned`.linkedliststackqueue

import java.util.ArrayDeque

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 */
// time / space O(n)
class DecodeString {
    fun decodeString(s: String): String {
        val stack = ArrayDeque<StringBuilder>()
        val numStack = ArrayDeque<Int>()
        var currentString = StringBuilder()
        var k = 0

        for (char in s) {
            when {
                char.isDigit() -> {
                    k = k * 10 + (char - '0') // Build the repeat count
                }
                char == '[' -> {
                    // Push the current number and currentString onto the stack
                    numStack.push(k)
                    stack.push(currentString)
                    // Reset for a new section
                    currentString = StringBuilder()
                    k = 0
                }
                char == ']' -> {
                    // Pop the last repeat count and string from the stack
                    val repeatTimes = numStack.pop()
                    val decodedPart = currentString.toString().repeat(repeatTimes)
                    currentString = stack.pop().append(decodedPart)
                }
                else -> {
                    // Accumulate characters in the current string
                    currentString.append(char)
                }
            }
        }
        return currentString.toString()
    }
}