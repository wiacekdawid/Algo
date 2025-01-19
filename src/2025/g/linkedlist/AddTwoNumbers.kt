package `2025`.g.linkedlist

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class AddTwoNumbers {
    // time / space O(max(m, n))
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var currentL1 = l1
        var currentL2 = l2

        var carry = 0
        val dummyNode = ListNode(0) // Dummy node to simplify result construction
        var current = dummyNode

        while (currentL1 != null || currentL2 != null) {
            val sum = (currentL1?.`val` ?: 0) + (currentL2?.`val` ?: 0) + carry
            carry = sum / 10
            current.next = ListNode(sum % 10) // Create a new node with the digit
            current = current.next!!

            currentL1 = currentL1?.next
            currentL2 = currentL2?.next
        }

        if (carry != 0) {
            current.next = ListNode(carry)
        }

        return dummyNode.next // Return the next node of dummy
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}