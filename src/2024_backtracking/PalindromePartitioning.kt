package `2024_backtracking`

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 */

// time O(n 2pown) / space O(n)
class PalindromePartitioning {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()

        fun isPalindrome(sub: String): Boolean {
            var left = 0
            var right = sub.length - 1
            while (left < right) {
                if (sub[left] != sub[right]) return false
                left++
                right--
            }
            return true
        }

        fun backtrack(start: Int, current: MutableList<String>) {
            // Base Case: If we've reached the end of the string, add the current partition
            if (start == s.length) {
                result.add(current.toList())
                return
            }

            // Explore all substrings starting from `start`
            for (end in start until s.length) {
                val substring = s.substring(start, end + 1)
                if (isPalindrome(substring)) {
                    current.add(substring) // Choose
                    backtrack(end + 1, current) // Explore
                    current.removeAt(current.size - 1) // Backtrack
                }
            }
        }

        backtrack(0, mutableListOf())
        return result
    }
}