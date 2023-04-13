package `75plan`.level1


/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */

class MiddleOfTheLinkedList {
    // time O(N), space O(1)
    fun middleNode(head: ListNode?): ListNode? {
        var slowerNode = head
        var fasterNode = head
        while (fasterNode?.next != null) {
            slowerNode = slowerNode?.next
            fasterNode = fasterNode.next?.next
        }
        return slowerNode
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
        }
}