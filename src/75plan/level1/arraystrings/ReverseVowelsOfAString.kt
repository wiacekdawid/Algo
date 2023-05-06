package `75plan`.level1.arraystrings

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 */
fun main() {
    val test = ReverseVowelsOfAString().reverseVowels("leetcode")
}
class ReverseVowelsOfAString {
    // time / space O(n)
    fun reverseVowels(s: String): String {
        val setOfVowels = setOf('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U')
        val reverse = s.toCharArray()
        var pointerStart = 0
        var pointerEnd = s.length-1
        while (pointerStart < pointerEnd) {
            while (pointerStart < pointerEnd && !setOfVowels.contains(reverse[pointerStart]))
                pointerStart++

            while (pointerStart < pointerEnd && !setOfVowels.contains(reverse[pointerEnd]))
                pointerEnd--

            if (setOfVowels.contains(reverse[pointerStart]) &&
                setOfVowels.contains(reverse[pointerEnd])) {
                val temp = reverse[pointerStart]
                reverse[pointerStart] = reverse[pointerEnd]
                reverse[pointerEnd] = temp
            }
            pointerStart++
            pointerEnd--

        }

        return String(reverse)
    }
}