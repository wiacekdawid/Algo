package `2024_backtracking`

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
class CombinationSum {
    // time O(2powN) / space O(N)
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(start: Int, current: MutableList<Int>, currentSum: Int) {
            // Base Case: If the current sum equals the target, add the combination to the result
            if (currentSum == target) {
                result.add(current.toList())
                return
            }

            // Stop exploring if the sum exceeds the target
            if (currentSum > target) return

            // Explore candidates starting from the current index
            for (i in start until candidates.size) {
                current.add(candidates[i]) // Choose the candidate
                backtrack(i, current, currentSum + candidates[i]) // Recurse
                current.removeAt(current.lastIndex) // Backtrack
            }
        }

        backtrack(0, mutableListOf(), 0)
        return result
    }

    // to handle negative numbers
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val seen = mutableSetOf<Pair<Int, List<Int>>>()

        fun backtrack(start: Int, current: MutableList<Int>, currentSum: Int) {
            // Base Case: If the current sum equals the target, add the combination to the result
            if (currentSum == target) {
                result.add(current.toList())
                return
            }

            // Avoid revisiting the same state
            if (seen.contains(Pair(currentSum, current.toList()))) return
            seen.add(Pair(currentSum, current.toList()))

            // Explore candidates starting from the current index
            for (i in start until candidates.size) {
                current.add(candidates[i]) // Choose the candidate
                backtrack(i, current, currentSum + candidates[i]) // Recurse
                current.removeAt(current.lastIndex) // Backtrack
            }
        }

        backtrack(0, mutableListOf(), 0)
        return result
    }
}