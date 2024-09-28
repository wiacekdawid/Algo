package `2024_restart`.noplan

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 */
class LRUCache(capacity: Int) {

    // Doubly Linked List Node
    data class Node(
        var key: Int = 0,
        var value: Int = 0,
        var prev: Node? = null,
        var next: Node? = null
    )

    // Map to store key and reference to the node in the doubly linked list
    private val map = HashMap<Int, Node>()

    // Head and Tail pointers for the doubly linked list
    private val head = Node()
    private val tail = Node()
    private val initCapacity = capacity

    init {
        // Initialize the doubly linked list with dummy head and tail nodes
        head.next = tail
        tail.prev = head
    }

    // Get the value (will move the node to the front if found)
    fun get(key: Int): Int {
        val node = map[key]
        return if (node != null) {
            // Move the accessed node to the head (mark as recently used)
            moveToHead(node)
            node.value
        } else {
            -1
        }
    }

    // Put a new key-value pair in the cache
    fun put(key: Int, value: Int) {
        val node = map[key]

        if (node != null) {
            // Key exists, update the value
            node.value = value
            moveToHead(node)
        } else {
            // Key doesn't exist, create a new node
            val newNode = Node(key, value)
            map[key] = newNode
            addNode(newNode)

            if (map.size > initCapacity) {
                // If the capacity is exceeded, remove the least recently used item
                val tail = popTail()
                map.remove(tail.key)
            }
        }
    }

    // Add a new node right after the head
    private fun addNode(node: Node) {
        node.prev = head
        node.next = head.next

        head.next?.prev = node
        head.next = node
    }

    // Remove an existing node from the linked list
    private fun removeNode(node: Node) {
        val prev = node.prev
        val next = node.next

        prev?.next = next
        next?.prev = prev
    }

    // Move a given node to the head (most recently used)
    private fun moveToHead(node: Node) {
        removeNode(node)
        addNode(node)
    }

    // Pop the least recently used node (from the tail)
    private fun popTail(): Node {
        val res = tail.prev!!
        removeNode(res)
        return res
    }
}