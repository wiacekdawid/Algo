package `2024_planned`.linkedliststackqueue

import java.util.*

/**
 * You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time.
 * This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.
 * You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns
 * the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.
 * Implement the KthLargest class:
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
 * int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
 */
class KthLargestElementInAStream (k: Int, nums: IntArray) {
    // space O(k)
    private val currentQueue = PriorityQueue<Int>()
    private val _k = k
    // time O(nlogk)
    init {
        nums.forEach { add(it) } // Use add method to simplify initialization
    }

    // time O(logk)
    fun add(`val`: Int): Int {
        currentQueue.add(`val`)
        if (currentQueue.size > _k) {
            currentQueue.poll() // Maintain only k largest elements
        }
        return currentQueue.peek() // The kth largest element
    }
}