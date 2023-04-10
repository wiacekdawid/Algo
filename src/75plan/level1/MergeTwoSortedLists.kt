package `75plan`.level1

class MergeTwoSortedLists {
    // time space O(max(n1, n2))
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var currentL1 = list1
        var currentL2 = list2
        var newHead: ListNode? = null
        var currentHead: ListNode? = null
        while (currentL2 != null || currentL1 != null) {
            val val1 = currentL1?.`val` ?: Int.MAX_VALUE
            val val2 = currentL2?.`val` ?: Int.MAX_VALUE
            if (val1 < val2) {
                if (currentHead == null) {
                    currentHead = ListNode(val1)
                    newHead = currentHead
                } else {
                    currentHead.next = ListNode(val1)
                    currentHead = currentHead.next
                }
                currentL1 = currentL1?.next
            } else {
                if (currentHead == null) {
                    currentHead = ListNode(val2)
                    newHead = currentHead
                } else {
                    currentHead.next = ListNode(val2)
                    currentHead = currentHead.next
                }
                currentL2 = currentL2?.next
            }
        }
        return newHead
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}