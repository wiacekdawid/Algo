package `75plan`.level1.arraystrings

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 */

fun main() {
    val test = CanPlaceFlowers().canPlaceFlowers(intArrayOf(1,0,0,0,0,1), 2)
}
class CanPlaceFlowers {
    // time O(n) space O(1)
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var numberOfNewlyPlanted = n
        var isPreviousPlanted = false
        if (n == 0) return true
        flowerbed.forEachIndexed { index, i ->
            val isPreviousFree = index == 0 || (flowerbed[index-1] == 0 && !isPreviousPlanted)
            val isNextFree = index == flowerbed.size-1 || flowerbed[index+1] == 0

            isPreviousPlanted = if (isPreviousFree && isNextFree && i == 0) {
                numberOfNewlyPlanted--
                true
            } else {
                false
            }

            if (numberOfNewlyPlanted == 0) return true
        }
        return false
    }
}