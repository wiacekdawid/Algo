package `75plan`.level1

class LinkedListCycle2 {
    // time / space O(n)
    fun detectCycle(head: ListNode?): ListNode? {
        val nodes = mutableSetOf<ListNode>()
        var currentHead = head
        while(currentHead != null) {
            if (nodes.contains(currentHead)) {
                return currentHead
            }
            nodes.add(currentHead)
            currentHead = currentHead.next
        }
        return null
    }

    fun detectCycle2(head: ListNode?): ListNode? {

    }

    private fun findIntersection(head: ListNode?): ListNode? {
        val slow = head
        val fast = head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}