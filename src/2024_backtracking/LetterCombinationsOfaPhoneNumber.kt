package `2024_backtracking`

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */


// time / space O(n)
class LetterCombinationsOfaPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val digitToLetters = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        val result = mutableListOf<String>()

        fun backtrack(index: Int, current: StringBuilder) {
            // Base case: If the current combination is complete
            if (index == digits.length) {
                result.add(current.toString())
                return
            }

            // Get the letters for the current digit
            val letters = digitToLetters[digits[index]] ?: return

            // Iterate over each letter and recurse
            for (letter in letters) {
                current.append(letter) // Choose a letter
                backtrack(index + 1, current) // Recurse for the next digit
                current.deleteCharAt(current.length - 1) // Backtrack
            }
        }

        backtrack(0, StringBuilder())
        return result
    }
}