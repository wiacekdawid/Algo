package `75plan`.queue

import java.util.*

/**
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 * Implement the RecentCounter class:
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
 * and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
 * Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 */
class NumberOfRecentCalls {
    // Time O(logn) / space O(n)
    private val queue = PriorityQueue<Int>()
    fun ping(t: Int): Int {
        queue.add(t)
        queue.removeIf {
            it < t - 3000
        }
        return queue.size
    }

    // Time O(n) / space O(n)
    private val listOfPings = LinkedList<Int>()
    fun ping2(t: Int): Int {
        listOfPings.add(t)
        while(listOfPings.peekFirst() < t-3000) {
            listOfPings.removeFirst()
        }
        return listOfPings.size
    }
}