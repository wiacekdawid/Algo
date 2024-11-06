package `2024_planned`.linkedlist

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 */

// time O(n) / space O(1)
class LinkedListCycleII {
    fun detectCycle(head: ListNode?): ListNode? {
        val intersection = findIntersection(head)

        if (intersection != null) {
            var currentHead = head
            var currIntersection = intersection

            while (currentHead != currIntersection) {
                currentHead = currentHead?.next
                currIntersection = currIntersection?.next
            }
            return currentHead
        }

        return null
    }

    private fun findIntersection(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (fast == slow) {
                return fast
            }
        }
        return null
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}