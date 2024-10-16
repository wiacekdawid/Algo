package `2024_planned`.arrayStringsHashTables

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string ""
 */
// time O(n) / space O(1)
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty() || strs.first().isEmpty()) return ""

        val str = StringBuilder()
        val firstStr = strs.first()

        for (currentIndex in firstStr.indices) {
            val currentLetter = firstStr[currentIndex]
            for (i in 1 until strs.size) {
                if (currentIndex >= strs[i].length || strs[i][currentIndex] != currentLetter) {
                    return str.toString()
                }
            }
            str.append(currentLetter)
        }

        return str.toString()
    }
}