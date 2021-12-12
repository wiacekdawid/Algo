package treesandgraphs

import java.util.*

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * time/space O(N)
 */

class PopulatingNextRightPointersInEachNode {
    fun connect(root: Node?): Node? {
        val queue = LinkedList<Node>()
        root?.let { queue.add(it) }
        while(queue.isNotEmpty()) {
            val currentSize = queue.size
            var counter = 0
            while (counter < currentSize) {
                val current = queue.poll()
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
                if (counter < currentSize-1) {
                    current.next = queue.peek()
                } else {
                    current.next = null
                }
                counter++
            }
        }
        return root
    }

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }
}