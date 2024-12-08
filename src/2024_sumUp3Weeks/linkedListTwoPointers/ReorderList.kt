package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */

// time O(n) / space O(1)
class ReorderList {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        // Step 1: Find the middle of the list (slow and fast pointer approach)
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Step 2: Reverse the second half of the list
        var second = slow?.next
        slow?.next = null // Split the list into two halves
        var prev: ListNode? = null
        while (second != null) {
            val next = second.next
            second.next = prev
            prev = second
            second = next
        }

        // Step 3: Merge the two halves
        var first = head
        second = prev // second half is reversed
        while (second != null) {
            val temp1 = first?.next
            val temp2 = second.next

            first?.next = second
            second.next = temp1

            first = temp1
            second = temp2
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}