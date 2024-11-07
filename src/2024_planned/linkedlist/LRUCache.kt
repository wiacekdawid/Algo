package `2024_planned`.linkedlist

import java.util.*

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

// time O(1) / space O(capacity)
class LRUCache(capacity: Int) {
    private data class Node(var key: Int, var value: Int, var prev: Node? = null, var next: Node? = null)

    private val cache = mutableMapOf<Int, Node>()
    private val head = Node(0, 0) // Dummy head
    private val tail = Node(0, 0) // Dummy tail
    private val _capacity = capacity

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            val node = cache[key]!!
            node.value = value
            moveToHead(node)
        } else {
            if (cache.size >= _capacity) {
                removeLRU()
            }
            val newNode = Node(key, value)
            cache[key] = newNode
            addToHead(newNode)
        }
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun addToHead(node: Node) {
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }

    private fun removeLRU() {
        val lru = tail.prev!!
        removeNode(lru)
        cache.remove(lru.key)
    }
}