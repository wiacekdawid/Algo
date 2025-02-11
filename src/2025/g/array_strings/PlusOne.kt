package `2025`.g.array_strings

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.

 */
class PlusOne {
    // time space O(n)
    fun plusOne(digits: IntArray): IntArray {
        var carry = 1
        val output = digits.copyOf() // Copy original array to modify in place

        for (index in digits.indices.reversed()) {
            val current = output[index] + carry
            output[index] = current % 10
            carry = current / 10

            if (carry == 0) return output // Early return if no carry left
        }

        // If carry remains, prepend 1 (e.g., 999 → 1000)
        return intArrayOf(1) + output
    }
}