package `75plan`.linkedlist

/**
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */

class DeleteTheMiddleNodeOfALinkedList {
    // time O(n) / space O(1)
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }
        var fastHead = head.next?.next
        var slowHead = head
        while (fastHead?.next != null) {
            slowHead = slowHead?.next
            fastHead = fastHead.next?.next
        }

        slowHead?.next = slowHead?.next?.next
        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}