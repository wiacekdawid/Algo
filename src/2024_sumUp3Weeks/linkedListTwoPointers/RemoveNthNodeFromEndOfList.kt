package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

// time O(n) / space O(1)
class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null

        val dummy = ListNode(0).apply { next = head }
        var rightPointer: ListNode? = dummy
        var leftPointer: ListNode? = dummy

        // Move rightPointer `n + 1` steps forward so it gets `n` distance from leftPointer
        repeat(n + 1) {
            rightPointer = rightPointer?.next
        }

        // Move both pointers until rightPointer reaches the end
        while (rightPointer != null) {
            rightPointer = rightPointer?.next
            leftPointer = leftPointer?.next
        }

        // Remove the nth node from the end
        leftPointer?.next = leftPointer?.next?.next

        return dummy.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}