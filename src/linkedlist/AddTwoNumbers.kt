package linkedlist

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * time / space O(max(m,n)) where m/n are length of l1/l2
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null || l2 == null)
            return l1 ?: l2
        val head = ListNode(0)
        var current = head
        var l1Current = l1
        var l2Current = l2
        var carry = 0
        while (l1Current != null || l2Current != null) {
            val currentValue = (l1Current?.`val` ?: 0) + (l2Current?.`val` ?: 0) + carry
            current.next = ListNode(currentValue%10)
            carry = currentValue / 10
            current = current.next as ListNode
            l1Current = l1Current?.next
            l2Current = l2Current?.next
        }

        if (carry > 0)
            current.next = ListNode(carry)

        return head.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}