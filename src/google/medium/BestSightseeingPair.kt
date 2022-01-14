package google.medium

/**
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
 * Return the maximum score of a pair of sightseeing spots.
 * time O(n) / space O(1) - we can go from left or also from right and at each point check if we have got best value (this approach can be used also for other problems)
 */
class BestSightseeingPair {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        var indexLeft = 0
        var result = values[indexLeft] + indexLeft
        for (j in 1 until values.size) {
            var current = values[indexLeft] + values[j] + indexLeft - j
            result = Math.max(current, result)

            if (values[indexLeft] + indexLeft < values[j] + j) {
                indexLeft = j
            }
        }
        return result
    }
}