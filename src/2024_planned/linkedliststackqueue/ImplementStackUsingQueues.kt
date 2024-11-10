package `2024_planned`.linkedliststackqueue

import java.util.*

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */

// space O(n) / time push O(n) rest O(1)
class ImplementStackUsingQueues {
    private var queue1: Queue<Int> = LinkedList()
    private var queue2: Queue<Int> = LinkedList()

    fun push(x: Int) {
        // Step 1: Add new element to queue2
        queue2.add(x)

        // Step 2: Move all elements from queue1 to queue2
        while (queue1.isNotEmpty()) {
            queue2.add(queue1.remove())
        }

        // Step 3: Swap references
        val temp = queue1
        queue1 = queue2
        queue2 = temp
    }

    fun pop(): Int {
        return queue1.remove() // Removes the top of the stack, which is the front of queue1
    }

    fun top(): Int {
        return queue1.peek() // Returns the front element of queue1 without removing it
    }

    fun empty(): Boolean {
        return queue1.isEmpty()
    }
}