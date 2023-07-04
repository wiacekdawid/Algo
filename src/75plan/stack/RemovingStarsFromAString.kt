package `75plan`.stack

import java.util.*

/**
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * Note:
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
class RemovingStarsFromAString {
    // time / space O(n)
    fun removeStars(s: String): String {
        val stack = Stack<Char>()
        s.forEach {
            if (it == '*') {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
            } else {
                stack.add(it)
            }
        }

        val sb = StringBuilder()
        while(stack.isNotEmpty()) {
            sb.append(stack.pop())
        }
        return sb.reverse().toString()
    }
}