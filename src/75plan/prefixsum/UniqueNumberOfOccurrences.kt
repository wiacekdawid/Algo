package `75plan`.prefixsum

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 */

class UniqueNumberOfOccurrences {
    // time O(n) / space O(n)
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val mapOfOccur = HashMap<Int, Int>()
        arr.forEach {
            mapOfOccur[it] = mapOfOccur.getOrDefault(it, 0) + 1
        }
        val setOfOccur = HashSet<Int>(mapOfOccur.values)

        return setOfOccur.size == mapOfOccur.size
    }
}