package `2024_sumUp3Weeks`.stringsAndArrays

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
// time O(n x m) / space O(1)
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        var prefix = strs.first()

        for (i in 1 until strs.size) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length - 1)
                if (prefix.isEmpty()) return ""
            }
        }

        return prefix
    }
}