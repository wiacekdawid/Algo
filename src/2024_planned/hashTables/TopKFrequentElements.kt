package `2024_planned`.hashTables

import java.util.*

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */

class TopKFrequentElements {
    // time complexity O(nlogk) / space O(n)
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        // Step 2: Use a Min-Heap (PriorityQueue) to keep track of the top k elements
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        frequencyMap.forEach { (num, freq) ->
            minHeap.add(Pair(num, freq))
            if (minHeap.size > k) {
                minHeap.poll()  // Remove the least frequent element
            }
        }

        // Step 3: Extract the k most frequent elements from the heap
        return minHeap.map { it.first }.toIntArray()
    }

    // bucket solution - time/space O(n)
    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
        // Step 1: Create a frequency map
        val frequencyMap = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        // Step 2: Create buckets to store numbers by frequency
        val bucket = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }

        // Step 3: Place numbers in the bucket based on frequency
        frequencyMap.forEach { (num, freq) ->
            bucket[freq].add(num)
        }

        // Step 4: Collect the top k frequent elements
        val result = mutableListOf<Int>()
        for (i in bucket.size - 1 downTo 0) {
            if (bucket[i].isNotEmpty()) {
                result.addAll(bucket[i])
                if (result.size >= k) {
                    break
                }
            }
        }

        return result.take(k).toIntArray()
    }
}