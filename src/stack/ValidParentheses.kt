package stack

import java.util.*

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * time/space O(n)
 */

class ValidParentheses {
    val map = mapOf('(' to ')', '{' to '}', '[' to ']')
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            when (it) {
                '(', '{', '[' -> {
                    stack.add(it)
                }
                else -> {
                    if (stack.isEmpty() || map[stack.pop()] != it)
                        return false
                }
            }
        }
        return stack.isEmpty()
    }
}