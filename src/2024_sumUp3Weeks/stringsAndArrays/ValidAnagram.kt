package `2024_sumUp3Weeks`.stringsAndArrays

// time O(n) / space O(1)
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.isEmpty() && t.isEmpty()) return true
        if (s.length != t.length) return false
        val sFrequency = IntArray(size = 26)
        val tFrequency = IntArray(size = 26)
        s.forEach {
            sFrequency[it - 'a']++
        }

        t.forEach {
            tFrequency[it - 'a']++
        }

        for (i in sFrequency.indices) {
            if (sFrequency[i] != tFrequency[i])
                return false
        }

        return true
    }
}