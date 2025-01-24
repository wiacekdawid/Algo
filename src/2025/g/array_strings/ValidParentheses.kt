package `2025`.g.array_strings

import java.util.*

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */

// time / space O(n)
class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return true

        val stack = ArrayDeque<Char>()

        for (char in s) {
            when (char) {
                '(', '{', '[' -> stack.addLast(char)
                else -> {
                    if (stack.isEmpty() || !matches(stack.removeLast(), char)) {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }

    private fun matches(open: Char, close: Char): Boolean {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']')
    }
}