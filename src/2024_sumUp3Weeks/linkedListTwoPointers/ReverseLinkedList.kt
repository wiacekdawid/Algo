package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

// time O(n) / space O(1)
class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var tempHead = head
        var previousNode: ListNode? = null

        while (tempHead != null) {
            val nextNode = tempHead.next
            tempHead.next = previousNode
            previousNode = tempHead
            tempHead = nextNode
        }

        return previousNode
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}