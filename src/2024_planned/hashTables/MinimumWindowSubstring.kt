package `2024_planned`.hashTables

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 */

// time O(m+n) / space O(n)
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) return ""

        // Step 1: Count frequency of each character in t
        val targetCount = mutableMapOf<Char, Int>()
        t.forEach { targetCount[it] = targetCount.getOrDefault(it, 0) + 1 }

        // Step 2: Sliding window setup
        val windowCount = mutableMapOf<Char, Int>()
        var have = 0  // Number of characters matched
        val need = targetCount.size
        var left = 0
        var minLength = Int.MAX_VALUE
        var result = ""

        // Step 3: Move the right pointer to expand the window
        for (right in s.indices) {
            val charRight = s[right]

            // Add the current character to the window
            if (charRight in targetCount) {
                windowCount[charRight] = windowCount.getOrDefault(charRight, 0) + 1
                if (windowCount[charRight] == targetCount[charRight]) {
                    have++
                }
            }

            // Step 4: Shrink the window if it's valid (contains all characters)
            while (have == need) {
                // Update the result if we found a smaller valid window
                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1
                    result = s.substring(left, right + 1)
                }

                // Shrink the window from the left
                val charLeft = s[left]
                if (charLeft in targetCount) {
                    windowCount[charLeft] = windowCount[charLeft]!! - 1
                    if (windowCount[charLeft]!! < targetCount[charLeft]!!) {
                        have--
                    }
                }
                left++
            }
        }

        return result
    }

    private fun addToContainer(currentChar: Char, container: Array<MutableList<Boolean>>) {
        if (container[currentChar.toInt() - 'a'.toInt()].contains(false)) {
            container[currentChar.toInt() - 'a'.toInt()].remove(false)
            container[currentChar.toInt() - 'a'.toInt()].add(true)
        }
    }

    private fun removeFromContainer(currentChar: Char, container: Array<MutableList<Boolean>>) {
        if (container[currentChar.toInt() - 'a'.toInt()].contains(true)) {
            container[currentChar.toInt() - 'a'.toInt()].remove(true)
            container[currentChar.toInt() - 'a'.toInt()].add(false)
        }
    }

    private fun isContainerFull(container: Array<MutableList<Boolean>>): Boolean {
        container.forEach {
            if (it.contains(false)) return false
        }
        return true
    }
}