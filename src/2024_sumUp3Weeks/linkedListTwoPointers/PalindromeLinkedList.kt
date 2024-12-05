package `2024_sumUp3Weeks`.linkedListTwoPointers

import java.util.*

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */

class PalindromeLinkedList {

    // time / space O(n)
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true // Empty or single-node list is a palindrome

        val stack = Stack<ListNode>()
        var slow = head
        var fast = head

        // Push the first half of the list onto the stack
        while (fast?.next != null) {
            stack.push(slow)
            slow = slow?.next
            fast = fast.next?.next
        }

        // Skip the middle node for odd-length lists
        if (fast != null) {
            slow = slow?.next
        }

        // Compare the second half of the list with the stack
        while (slow != null) {
            val current = stack.pop()
            if (slow.`val` != current.`val`) return false
            slow = slow.next
        }

        return true
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}