package `2024_planned`.linkedlist

/**
 * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer.
 * This child pointer may or may not point to a separate doubly linked list, also containing these special nodes.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
 * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 */
// time / space O(n)
class FlattenaMultilevelDoublyLinkedList {
    fun flatten(head: Node?): Node? {
        if (head == null) return null
        flattenRecursively(head)
        return head
    }

    private fun flattenRecursively(head: Node?): Node? {
        var curr = head
        var last: Node? = head

        while (curr != null) {
            val next = curr.next
            if (curr.child != null) {
                // Flatten the child list and attach to `curr`
                val childHead = curr.child
                val childLast = flattenRecursively(childHead)

                // Connect curr to child
                curr.next = childHead
                childHead?.prev = curr

                // Connect child's last node to next
                if (next != null) {
                    childLast?.next = next
                    next.prev = childLast
                }

                // Clear the child pointer
                curr.child = null

                // Update `last` to be the end of the flattened child
                last = childLast
            } else {
                last = curr
            }
            curr = next
        }
        return last
    }

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }
}