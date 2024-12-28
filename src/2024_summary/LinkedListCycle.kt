package `2024_summary`

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
class LinkedListCycle {
    // time O(n) / space O(1)
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false

        var fast = head
        var slow = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (fast == slow) {
                return true
            }
        }
        return false
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}