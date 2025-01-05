package `2025`.g.array_strings

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */
class CopyListWithRandomPointer {
    // time / space O(n)
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        val randomContainer = HashMap<Node, Node>()

        // Step 1: Create new nodes for each old node and store them in the map
        var current = node
        while (current != null) {
            randomContainer[current] = Node(current.`val`)
            current = current.next
        }

        // Step 2: Set `next` and `random` pointers for the new nodes
        current = node
        while (current != null) {
            val newNode = randomContainer[current]
            newNode?.next = randomContainer[current.next]
            newNode?.random = randomContainer[current.random]
            current = current.next
        }

        // Step 3: Return the head of the new list
        return randomContainer[node]
    }

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }
}