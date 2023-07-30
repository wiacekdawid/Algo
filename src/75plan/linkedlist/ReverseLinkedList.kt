package `75plan`.linkedlist

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 1 -> 2 -> 3
 * 3 -> 2 -> 1
 */

class ReverseLinkedList {
    // time O(n) / space O(1) // recursive one would have O(n) for both because of implicit stack space due to recursion
    fun reverseList(head: ListNode?): ListNode? {
        var previousNode: ListNode? = null
        var currentNode = head

        while (currentNode != null) {
            val temp = currentNode.next
            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = temp
        }

        return previousNode
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}