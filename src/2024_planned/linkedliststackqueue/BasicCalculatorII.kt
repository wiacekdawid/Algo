package `2024_planned`.linkedliststackqueue

import java.util.ArrayDeque

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 */

// time / space O(n)
class BasicCalculatorII {
    fun calculate(s: String): Int {
        val stack = ArrayDeque<Int>()
        var currentNumber = 0
        var lastOperator = '+'

        for (i in s.indices) {
            val c = s[i]

            if (c.isDigit()) {
                currentNumber = currentNumber * 10 + (c - '0')
            }

            // If current character is an operator or the last character of the string
            if (!c.isDigit() && c != ' ' || i == s.length - 1) {
                when (lastOperator) {
                    '+' -> stack.push(currentNumber)
                    '-' -> stack.push(-currentNumber)
                    '*' -> stack.push(stack.pop() * currentNumber)
                    '/' -> stack.push(stack.pop() / currentNumber)
                }
                lastOperator = c
                currentNumber = 0
            }
        }

        return stack.sum()
    }
}