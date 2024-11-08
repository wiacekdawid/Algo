package `2024_planned`.linkedliststackqueue

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

// time O(n) / space O(1)
class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0) // Dummy node to handle edge cases
        dummy.next = head
        var first: ListNode? = dummy
        var second: ListNode? = dummy

        // Move the first pointer n+1 steps ahead
        for (i in 0..n) {
            first = first?.next
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next
            second = second?.next
        }

        // Now, second pointer is just before the node to be deleted
        second?.next = second?.next?.next

        return dummy.next // Return the modified list, skipping dummy
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}