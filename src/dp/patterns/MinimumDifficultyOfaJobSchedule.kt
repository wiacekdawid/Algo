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
                    val rightMax = dp(currentDay-1, currentPosition+1, jobDifficulty)
                    minValue = minValue.coerceAtMost(leftMax+rightMax)
                }
                cache[currentDay][currentPosition] = minValue
            }
        }

        return cache[currentDay][currentPosition]
    }
}