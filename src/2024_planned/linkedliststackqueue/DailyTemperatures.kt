package `2024_planned`.linkedliststackqueue

import java.util.*

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
// time / space O(n)
class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) { 0 }
        val stack = Stack<Int>()

        for (i in temperatures.size - 1 downTo 0) {
            // Remove indices with temperatures less than or equal to current temperature
            while (stack.isNotEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop()
            }

            // If the stack is not empty, calculate the days difference
            if (stack.isNotEmpty()) {
                result[i] = stack.peek() - i
            }

            // Push the current index onto the stack
            stack.push(i)
        }

        return result
    }
}