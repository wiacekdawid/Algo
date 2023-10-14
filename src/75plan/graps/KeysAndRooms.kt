package `75plan`.graps

import java.util.*

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
 * denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 */

class KeysAndRooms {
    // time O(num_of_rooms + num_of_keys) / space O(num_of_rooms)
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val stack = Stack<Int>()
        val seen = BooleanArray(rooms.size)
        seen[0] = true

        stack.push(0)
        while(stack.isNotEmpty()) {
            val current = stack.pop()
            rooms[current].forEach {
                if (!seen[it]) {
                    seen[it] = true
                    stack.push(it)
                }
            }
        }
        seen.forEach {
            if (!it) return false
        }
        return true
    }
}