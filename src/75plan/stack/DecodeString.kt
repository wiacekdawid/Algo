package `75plan`.stack

import java.util.*
import kotlin.collections.ArrayList

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 */

fun main() {
    val test = DecodeString().decodeString("3[a]2[bc]")
}

class DecodeString {
    // time O([maxK] to power of [countK] * maxLenghtS) / space O(sum([maxK] to power of [countK] * maxLenghtS))
    fun decodeString(s: String): String {
        val stack = Stack<Char>()
        s.forEach {
            if (it == ']') {
                val decodeString = ArrayList<Char>()
                while(stack.peek() != '[') {
                    decodeString.add(stack.pop())
                }

                // for [
                stack.pop()

                var base = 1
                var k = 0

                while (stack.isNotEmpty() && stack.peek().isDigit()) {
                    k += (stack.pop() - '0') * base
                    base *= 10
                }

                while (k > 0) {
                    for (i in decodeString.size-1 downTo 0) {
                        stack.push(decodeString[i])
                    }
                    k--
                }
            } else {
                stack.push(it)
            }
        }

        val results = StringBuilder()
        for (i in stack.size-1 downTo 0) {
            results.append(stack.pop())
        }
        results.reverse()

        return results.toString()
    }
}