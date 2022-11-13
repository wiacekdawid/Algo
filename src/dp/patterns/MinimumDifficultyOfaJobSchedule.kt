package dp.patterns

/**
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job,
 * you have to finish all the jobs j where 0 <= j < i).
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum
 * of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 */

fun main() {
    val test = MinimumDifficultyOfaJobSchedule().minDifficulty(intArrayOf(6,5,4,3,2,1), 2)
    val test1 = test
}

class MinimumDifficultyOfaJobSchedule {

    /**
     * top down - time O(n^2 * d) - space O(n*d)
     */
    private lateinit var cache: Array<IntArray>

    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {

        if (jobDifficulty.size < d)
            return -1

        cache = Array(d+1) { IntArray(jobDifficulty.size) { -1 } }

        return dp(d, 0, jobDifficulty)
    }

    private fun dp(currentDay: Int, currentPosition: Int,
                   jobDifficulty: IntArray): Int {
        if (cache[currentDay][currentPosition] == -1) {
            if (currentDay == 1) {
                var maxValue = 0
                for (i in currentPosition until jobDifficulty.size) {
                    maxValue = maxValue.coerceAtLeast(jobDifficulty[i])
                }
                cache[currentDay][currentPosition] = maxValue
            } else {
                var minValue = Int.MAX_VALUE
                var leftMax = 0
                for (i in currentPosition until jobDifficulty.size - currentDay + 1) {
                    leftMax = leftMax.coerceAtLeast(jobDifficulty[i])
                    val rightMax = dp(currentDay-1, i+1, jobDifficulty)
                    minValue = minValue.coerceAtMost(leftMax+rightMax)
                }
                cache[currentDay][currentPosition] = minValue
            }
        }

        return cache[currentDay][currentPosition]
    }

    /**
     * bottom up - time O(n^2 * d) - space O(n*d)
     */

    fun minDifficulty2(jobDifficulty: IntArray, d: Int): Int {
        val n = jobDifficulty.size

        val minDiff = Array(d + 1) { IntArray(n + 1) }

        for (daysRemaining in 0..d) {
            for (i in 0 until n) {
                minDiff[daysRemaining][i] = Int.MAX_VALUE
            }
        }

        for (daysRemaining in 1..d) {
            for (i in 0 until n - daysRemaining + 1) {
                var dailyMaxJobDiff = 0
                for (j in i + 1 until n - daysRemaining + 2) {

                    dailyMaxJobDiff = dailyMaxJobDiff.coerceAtLeast(jobDifficulty[j - 1])

                    if (minDiff[daysRemaining - 1][j] != Int.MAX_VALUE) {
                        minDiff[daysRemaining][i] =
                            minDiff[daysRemaining][i].coerceAtMost(dailyMaxJobDiff + minDiff[daysRemaining - 1][j])
                    }
                }
            }
        }
        return if (minDiff[d][0] < Int.MAX_VALUE) minDiff[d][0] else -1
    }
}