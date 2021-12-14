package stack

import java.lang.StringBuilder
import java.util.*

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
 * being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits
 * and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Input: s = "3[a2[c]]" Output: "accaccacc"
 * Time Complexity: O(maxK⋅n) / space O(m+n) where m num of letters / n num of digits
 */
class DecodeString {
    fun decodeString(s: String): String {
        val repeatStack = Stack<String>()
        val countStack = Stack<Int>()
        var result = ""
        var counter = 0
        while (counter < s.length) {
            val current = s[counter]
            when {
                current == '[' -> {
                    repeatStack.add(result)
                    result = ""
                    counter++
                }
                current == ']' -> {
                    val sb = StringBuilder(repeatStack.pop())
                    for (i in 0 until countStack.pop()) {
                        sb.append(result)
                    }
                    result = sb.toString()
                    counter++
                }
                current.isDigit() -> {
                    var count = 0
                    while (counter < s.length && s[counter].isDigit()) {
                        count = 10 * count + (s[counter].toInt() - '0'.toInt())
                        counter++
                    }
                    countStack.add(count)
                }
                else -> {
                    result += current
                    counter++
                }
            }
        }
        return result
    }
}