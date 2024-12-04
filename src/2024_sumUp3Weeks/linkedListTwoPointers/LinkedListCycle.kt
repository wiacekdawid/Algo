package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */

class LinkedListCycle {
    // time O(n) / space O(n)
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false
        val visited = HashMap<ListNode, Boolean>()

        var currentNode = head

        while (currentNode != null) {
            if (visited.containsKey(currentNode)) {
                return true
            }
            visited[currentNode] = true
        }

        return false
    }

    // time O(n) / space O(1)
    fun hasCycle2(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next        // Move slow pointer by 1 step
            fast = fast.next?.next    // Move fast pointer by 2 steps

            if (slow == fast) {
                return true           // Cycle detected
            }
        }

        return false
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}