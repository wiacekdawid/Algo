package arraysandstrings

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * time / space (O(n)) / space is O(1) if we are using IntArray(26)
 */

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val map = mutableMapOf<Char, Int>()

        s.forEach {
            if (map.containsKey(it)) {
                map[it] = (map[it] ?: 0) + 1
            } else {
                map[it] = 1
            }
        }

        t.forEach {
            if (map.containsKey(it)) {
                if ((map[it] ?: 0) == 1) {
                    map.remove(it)
                } else {
                    map[it] = (map[it] ?: 0) - 1
                }
            } else {
                return false
            }
        }
        return true
    }
    // other approaches

//    fun isAnagram(s: String, t: String): Boolean {
//        if (s.length != t.length) return false
//        val map1 = HashMap<Char, Int>()
//        val map2 = HashMap<Char, Int> ()
//        s.forEach { map1[it] = map1.getOrDefault(it, 0) + 1  }
//        t.forEach { map2[it] = map2.getOrDefault(it, 0) + 1  }
//        map1.forEach {
//            if (map2.getOrDefault(it.key, -1) != it.value) return false
//        }
//        return true
//    }

//     fun isAnagram(s: String, t: String): Boolean {
//         if (s.length != t.length) return false

//         val counter = IntArray(26)

//         s.forEachIndexed { index, c ->
//             counter[c.toInt().minus('a'.toInt())]++
//             counter[t[index].toInt().minus('a'.toInt())]--
//         }

//         counter.forEach {
//             if (it != 0)
//                 return false
//         }
//         return true
//     }
}