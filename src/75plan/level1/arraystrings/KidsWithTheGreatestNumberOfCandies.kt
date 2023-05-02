package `75plan`.level1.arraystrings

/**
 * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has,
 * and an integer extraCandies, denoting the number of extra candies that you have.
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
 * they will have the greatest number of candies among all the kids, or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 */
class KidsWithTheGreatestNumberOfCandies {
    // time O(n) / space O(1)
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxCandies = candies.max() ?: 0
        val result = mutableListOf<Boolean>()
        candies.forEach { current ->
            result.add((current + extraCandies) >= maxCandies)
        }
        return result.toList()
    }
}