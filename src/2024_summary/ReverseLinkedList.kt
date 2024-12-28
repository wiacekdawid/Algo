package `2024_summary`

class ReverseLinkedList {
    // time O(n) / space O(1)
    fun reverseList(head: ListNode?): ListNode? {
        var currentHead = head
        var previousNode: ListNode? = null
        while (currentHead != null) {
            val nextNode = currentHead.next
            currentHead.next = previousNode
            previousNode = currentHead
            currentHead = nextNode
        }
        return previousNode
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}