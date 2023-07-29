package `75plan`.linkedlist

import `75plan`.linkedlist.OddEvenLinkedList.ListNode

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed
 * by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next = ListNode(6)
    head.next?.next?.next?.next?.next?.next = ListNode(7)
    head.next?.next?.next?.next?.next?.next?.next = ListNode(8)
    val test = OddEvenLinkedList().oddEvenList(head)
}
class OddEvenLinkedList {
    // time O(n) / space O(1)
    fun oddEvenList(head: ListNode?): ListNode? {
        var odd = head
        var even: ListNode? = head?.next
        val evenHead = even

        while(even?.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }

        odd?.next = evenHead

        return head
    }
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}