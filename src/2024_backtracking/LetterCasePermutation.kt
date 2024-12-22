package `2024_backtracking`

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 */

class LetterCasePermutation {
    // time O(2 pow m x n) where m is num of letters and n is string building in each recursive step / space O(n)
    fun letterCasePermutation(s: String): List<String> {

        val output = mutableListOf<String>()

        fun backtrack(index: Int, current: CharArray) {
            // Base Case: If we've processed the entire string, add it to the output
            if (index == s.length) {
                output.add(String(current))
                return
            }

            // Recurse without changing the current character
            backtrack(index + 1, current)

            // If the current character is a letter, toggle its case and recurse
            if (current[index].isLetter()) {
                current[index] = if (current[index].isLowerCase()) {
                    current[index].toUpperCase()
                } else {
                    current[index].toLowerCase()
                }

                backtrack(index + 1, current)

                // Backtrack by resetting the character
                current[index] = if (current[index].isLowerCase()) {
                    current[index].toUpperCase()
                } else {
                    current[index].toLowerCase()
                }
            }
        }

        backtrack(0, s.toCharArray())
        return output
    }
}