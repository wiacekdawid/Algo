package `2024_summary`

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 */

class LetterCasePermutation {
    // time O(n 2 pow m) / space O(n) where m is num of letters (only letters) / n is num of all characters (num and letters)
    fun letterCasePermutation(s: String): List<String> {
        val output = mutableListOf<String>()

        fun backtrack(currentIndex: Int, currentString: CharArray) {
            if (currentIndex == s.length) {
                output.add(String(currentString))
                return
            }

            // Always backtrack without changing the current character
            backtrack(currentIndex + 1, currentString)

            // If it's a letter, try flipping its case
            if (s[currentIndex].isLetter()) {
                currentString[currentIndex] = if (currentString[currentIndex].isLowerCase()) {
                    currentString[currentIndex].toUpperCase()
                } else {
                    currentString[currentIndex].toLowerCase()
                }
                backtrack(currentIndex + 1, currentString)

                // Backtrack: undo the case change
                currentString[currentIndex] = if (currentString[currentIndex].isLowerCase()) {
                    currentString[currentIndex].toUpperCase()
                } else {
                    currentString[currentIndex].toLowerCase()
                }
            }
        }

        backtrack(0, s.toCharArray())
        return output
    }
}