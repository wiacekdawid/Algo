package `2024_planned`.linkedliststackqueue

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

// time O(n) / space O(1)
class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var currentNode = head
        var currentNext = head?.next
        var previous: ListNode? = null
        while (currentNode != null) {
            currentNext = currentNode.next
            currentNode.next = previous
            previous = currentNode
            currentNode = currentNext

        }
        return currentNode
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}