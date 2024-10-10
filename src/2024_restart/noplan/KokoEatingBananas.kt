package `2024_restart`.noplan

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */

// time O(n log m) where n is num of piles and m is max num of bananas in piles / space O(1)
class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        fun canFinishInTime(k: Int): Boolean {
            var hoursNeededToFinish = 0
            for (pile in piles) {
                hoursNeededToFinish += (pile + k - 1) / k
            }
            return hoursNeededToFinish <= h
        }

        var left = 1
        var right = piles.max() ?: 1

        while(left < right) {
            val mid = left + (right - left)/2
            if (canFinishInTime(mid)) {
                right = mid
            } else {
                left = mid+1
            }
        }
        return left
    }
}