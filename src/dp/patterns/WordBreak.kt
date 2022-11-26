package dp.patterns

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into
 * a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
class WordBreak {
    // top down

    lateinit var cache: IntArray

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        cache = IntArray(s.length)
        return dp(s.length, s, wordDict)
    }

    private fun dp(i: Int, s: String, wordDict: List<String>): Boolean {
        if (i < 0) return true

        if (cache[i] == -1) {
            for (word in wordDict) {
                if (i >= word.length - 1 && dp(i - word.length, s, wordDict)) {
                    if (s.substring(i - word.length + 1, i + 1) == word) {
                        cache[i] = 1
                        break
                    }
                }
            }
        }

        if (cache[i] == -1) {
            cache[i] = 0
        }

        return cache[i] == 1
    }
}