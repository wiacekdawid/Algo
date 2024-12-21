package `2024_backtracking`

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 */

class RestoreIPAddresses {
    // time O(1) / space O(n) where n is length of string
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()

        fun isValid(segment: String): Boolean {
            // Segment should be a number between 0 and 255 with no leading zeros
            if (segment.isEmpty() || (segment.length > 1 && segment[0] == '0')) return false
            return segment.toInt() in 0..255
        }

        fun backtrack(start: Int, segments: MutableList<String>) {
            // Base case: If 4 segments are formed and the entire string is used
            if (segments.size == 4) {
                if (start == s.length) {
                    result.add(segments.joinToString("."))
                }
                return
            }

            // Explore all possible segments
            for (end in start + 1..s.length) {
                val segment = s.substring(start, end)
                if (isValid(segment)) {
                    segments.add(segment) // Choose
                    backtrack(end, segments) // Explore
                    segments.removeAt(segments.size - 1) // Backtrack
                } else {
                    break // No need to continue if segment is invalid
                }
            }
        }

        backtrack(0, mutableListOf())
        return result
    }
}