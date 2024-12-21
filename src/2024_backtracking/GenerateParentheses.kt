package `2024_backtracking`

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

// time 1/n+1 (2n / n) / space O(n)
class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun backtrack(current: StringBuilder, open: Int, close: Int) {
            // Base Case: If the current string has 2 * n characters, it's a valid combination
            if (current.length == 2 * n) {
                result.add(current.toString())
                return
            }

            // Add '(' if we can still use more opening parentheses
            if (open < n) {
                current.append('(') // Choose
                backtrack(current, open + 1, close) // Explore
                current.deleteCharAt(current.length - 1) // Backtrack
            }

            // Add ')' if it won't violate the rules of valid parentheses
            if (close < open) {
                current.append(')') // Choose
                backtrack(current, open, close + 1) // Explore
                current.deleteCharAt(current.length - 1) // Backtrack
            }
        }

        backtrack(StringBuilder(), 0, 0)
        return result
    }
}