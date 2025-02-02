package `2025`.g.array_strings

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 */
// time / space O(n+m)
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty() || s.isEmpty()) return ""

        // Frequency map for characters in t.
        val tFreq = mutableMapOf<Char, Int>()
        for (c in t) {
            tFreq[c] = tFreq.getOrDefault(c, 0) + 1
        }

        // Number of unique characters in t that need to be present in the window
        val required = tFreq.size

        // Frequency map for the current window
        val windowFreq = mutableMapOf<Char, Int>()
        var l = 0
        var r = 0
        var formed = 0
        var ans = Pair(Int.MAX_VALUE, Pair(0, 0)) // (window length, (left, right))

        while (r < s.length) {
            // Add one character from the right into the window
            val c = s[r]
            windowFreq[c] = windowFreq.getOrDefault(c, 0) + 1

            // Check if the current character count matches the required count in tFreq
            if (tFreq.containsKey(c) && windowFreq[c] == tFreq[c]) {
                formed++
            }

            // Try to contract the window until it's no longer valid
            while (l <= r && formed == required) {
                // Update the result if this window is smaller
                if (r - l + 1 < ans.first) {
                    ans = Pair(r - l + 1, Pair(l, r))
                }

                // The character at the left pointer
                val leftChar = s[l]
                windowFreq[leftChar] = windowFreq.getOrDefault(leftChar, 0) - 1
                if (tFreq.containsKey(leftChar) && windowFreq[leftChar]!! < tFreq[leftChar]!!) {
                    formed--
                }
                l++
            }

            r++
        }

        return if (ans.first == Int.MAX_VALUE) "" else s.substring(ans.second.first, ans.second.second + 1)
    }
}