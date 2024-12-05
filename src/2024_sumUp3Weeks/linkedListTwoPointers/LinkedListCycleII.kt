package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 */

// time O(n) / space O(1)
class LinkedListCycleII {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var slow: ListNode? = head
        var fast: ListNode? = head

        // Step 1: Detect if a cycle exists
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) {
                // Step 2: Find the starting node of the cycle
                var pointer1: ListNode? = head
                var pointer2: ListNode? = slow
                while (pointer1 != pointer2) {
                    pointer1 = pointer1?.next
                    pointer2 = pointer2?.next
                }
                return pointer1 // The start of the cycle
            }
        }

        return null // No cycle
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}