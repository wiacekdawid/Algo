package `75plan`.level1.arraystrings

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
class ReverseWordsInAString {
    // time/space O(n)
    fun reverseWords(s: String): String {
        val reverseWord = mutableListOf<String>()

        var isWordStart = false
        val sb = StringBuilder()
        s.forEach {
            if (!it.equals(' ')) {
                if (!isWordStart) {
                    isWordStart = true
                }
                sb.append(it)
            } else {
                if (isWordStart) {
                    reverseWord.add(sb.toString())
                    sb.clear()
                    isWordStart = false
                }
            }
        }

        if (sb.isNotEmpty()) {
            reverseWord.add(sb.toString())
        }
        sb.clear()

        reverseWord.reverse()

        return reverseWord.joinToString(separator = " ")
    }
}