package `2024_summary`

import java.lang.StringBuilder

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

class GenerateParentheses {
    // time O(2 pow N) - but check Catalan number / space O(n)
    fun generateParenthesis(n: Int): List<String> {
        val output = mutableListOf<String>()

        fun backtrack(currentCombination: StringBuilder, open: Int, close: Int) {
            if (currentCombination.length == 2*n) {
                output.add(currentCombination.toString())
                return // Stop further exploration
            }

            // Add '(' if we can still use more opening parentheses
            if (open < n) {
                currentCombination.append('(') // Choose
                backtrack(currentCombination, open + 1, close) // Explore
                currentCombination.deleteCharAt(currentCombination.length - 1) // Backtrack
            }

            // Add ')' if it won't violate the rules of valid parentheses
            if (close < open) {
                currentCombination.append(')') // Choose
                backtrack(currentCombination, open, close + 1) // Explore
                currentCombination.deleteCharAt(currentCombination.length - 1) // Backtrack
            }
        }

        backtrack(StringBuilder(), 0, 0)
        return output
    }
}