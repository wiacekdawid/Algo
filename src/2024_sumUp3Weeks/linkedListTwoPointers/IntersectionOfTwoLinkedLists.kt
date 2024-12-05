package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 */

class IntersectionOfTwoLinkedLists {
    // time O(m+n) / space O(1)
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null

        var pointerA = headA
        var pointerB = headB

        while (pointerA != pointerB) {
            pointerA = if (pointerA == null) headB else pointerA.next
            pointerB = if (pointerB == null) headA else pointerB.next
        }

        return pointerA // Either the intersection node or null if no intersection
    }

    // time O(m+n) / space O(m)
    fun getIntersectionNode2(headA: ListNode?, headB: ListNode?): ListNode? {
        val visited = HashSet<ListNode>()

        var currentA = headA
        var currentB = headB

        while (currentA != null) {
            visited.add(currentA)
            currentA = currentA.next
        }

        while (currentB != null) {
            if (visited.contains(currentB)) {
                return currentB
            }
            currentB = currentB.next
        }

        return null
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}