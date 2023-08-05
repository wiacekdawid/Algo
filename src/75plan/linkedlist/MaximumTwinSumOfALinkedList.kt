package `75plan`.linkedlist

/**
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
class MaximumTwinSumOfALinkedList {
    // time / space O(n)
    fun pairSum(head: ListNode?): Int {
        var current = head
        val listOfValues = ArrayList<Int>()

        while (current != null) {
            listOfValues.add(current.`val`)
            current = current.next
        }

        var maxSum = Int.MIN_VALUE

        var start = 0
        var end = listOfValues.size-1
        while (start < end) {
            maxSum = maxSum.coerceAtLeast(listOfValues[start++] + listOfValues[end--])
        }

        return maxSum
    }

    // time O(n) / space O(1)
    fun pairSum2(head: ListNode?): Int {
        var fast = head
        var slow = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        var prev: ListNode? = null
        var next: ListNode? = null

        while (slow != null) {
            next = slow.next
            slow.next = prev
            prev = slow
            slow = next
        }

        var start = head
        var maxSum = Int.MIN_VALUE
        while (prev != null) {
            maxSum = maxSum.coerceAtLeast(prev.`val` + (start?.`val` ?: 0))
            prev = prev.next
            start = start?.next
        }

        return maxSum
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}