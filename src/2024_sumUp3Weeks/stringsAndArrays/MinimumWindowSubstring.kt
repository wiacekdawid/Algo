package `2024_sumUp3Weeks`.stringsAndArrays

import java.util.ArrayDeque

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 */

// time O(n) / space O(t + s)
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) return ""

        val searchMap = mutableMapOf<Char, Int>()
        t.forEach { searchMap[it] = searchMap.getOrDefault(it, 0) + 1 }

        val currentMap = mutableMapOf<Char, Int>()
        var pointerL = 0
        var pointerR = 0
        var minLength = Int.MAX_VALUE
        var minStart = 0

        var required = searchMap.size
        var formed = 0

        while (pointerR < s.length) {
            // Add character at pointerR to currentMap
            val charR = s[pointerR]
            currentMap[charR] = currentMap.getOrDefault(charR, 0) + 1

            // Check if the current character satisfies a condition in searchMap
            if (searchMap.containsKey(charR) && currentMap[charR] == searchMap[charR]) {
                formed++
            }

            // Try to shrink the window
            while (formed == required) {
                if (pointerR - pointerL + 1 < minLength) {
                    minLength = pointerR - pointerL + 1
                    minStart = pointerL
                }

                val charL = s[pointerL]
                currentMap[charL] = currentMap[charL]!! - 1
                if (searchMap.containsKey(charL) && currentMap[charL]!! < searchMap[charL]!!) {
                    formed--
                }
                pointerL++
            }

            pointerR++
        }

        return if (minLength == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLength)
    }
}