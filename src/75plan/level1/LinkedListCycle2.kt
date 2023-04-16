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

    // time O(n) / space O(1) - Floyd algorithm
    fun detectCycle2(head: ListNode?): ListNode? {
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

        while(fast != null && fast.next != null) {
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