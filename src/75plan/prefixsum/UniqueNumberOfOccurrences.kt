package `75plan`.prefixsum

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 */

class UniqueNumberOfOccurrences {
    // time O(n) / space O(n)
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val setOfOccurr = HashSet<Int>()
        arr.forEach {
            if (setOfOccurr.contains(it)) return false
            setOfOccurr.add(it)
        }
        return true
    }
}