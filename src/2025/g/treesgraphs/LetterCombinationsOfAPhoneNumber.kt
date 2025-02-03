package `2025`.g.treesgraphs

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

class LetterCombinationsOfAPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val output = mutableListOf<String>()

        val digitToLetters: Map<Char, String> = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        fun backtrack(currentIndex: Int, currentList: StringBuilder) {
            if (currentList.length == digits.length) {
                output.add(currentList.toString())
                return
            }

            val letters = digitToLetters.get(digits[currentIndex]) ?: return
            letters.forEach {
                currentList.append(it)
                backtrack(currentIndex+1, currentList)
                currentList.deleteCharAt(currentList.length-1)
            }
        }

        backtrack(0, StringBuilder())
        return output.toList()
    }
}