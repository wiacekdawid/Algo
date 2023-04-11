package `75plan`.level1

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
class ReverseLinkedList {
    class Solution {
        // time O(n) space O(1)
        fun reverseList(head: ListNode?): ListNode? {
            var previous: ListNode? = null
            var currentHead = head

            while (currentHead != null) {
                val temp = currentHead.next
                currentHead.next = previous
                previous = currentHead
                currentHead = temp
            }

            return previous
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}