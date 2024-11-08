package `2024_planned`.linkedlist

import java.util.*

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
// time O(n) / space O(1)
class `ReverseNodesInk-Group` {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 1) return head

        // Dummy node to handle edge cases easily
        val dummy = ListNode(0)
        dummy.next = head

        var prevGroupTail: ListNode? = dummy
        var curr = head

        while (curr != null) {
            // Check if there are enough nodes to reverse
            var endOfGroup = curr
            for (i in 1 until k) {
                endOfGroup = endOfGroup?.next
                if (endOfGroup == null) return dummy.next // Not enough nodes left to reverse
            }

            // Mark the start and end of the current group
            val nextGroupHead = endOfGroup?.next
            val groupHead = curr

            // Reverse the group
            var prev: ListNode? = null
            var node = curr
            for (i in 0 until k) {
                val next = node?.next
                node?.next = prev
                prev = node
                node = next
            }

            // Connect the reversed group with the previous group
            prevGroupTail?.next = prev
            groupHead.next = nextGroupHead

            // Move prevGroupTail and curr forward to the next group
            prevGroupTail = groupHead
            curr = nextGroupHead
        }

        return dummy.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}