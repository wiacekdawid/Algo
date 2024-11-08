package `2024_planned`.linkedliststackqueue

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

// time O(n+m) / space O(1)
class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var currentList1 = list1
        var currentList2 = list2
        var currentNode: ListNode? = null

        if (list1.`val` >= list2.`val`) {
            currentNode = list2
            currentList2 = currentList2.next
        } else {
            currentNode = list1
            currentList1 = currentList1.next
        }
        val head = currentNode
        while (currentList1 != null && currentList2 != null) {
            if (currentList1.`val` >= currentList2.`val`) {
                currentNode?.next = currentList2
                currentList2 = currentList2.next
            } else {
                currentNode?.next = currentList1
                currentList1 = currentList1.next
            }
            currentNode = currentNode?.next
        }

        // Attach the remaining nodes
        currentNode?.next = currentList1 ?: currentList2

        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}