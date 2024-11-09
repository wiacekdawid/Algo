package `2024_planned`.linkedliststackqueue

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */

// time O(1) / space O(n)
class MinStack {
    private val mainStack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        mainStack.add(`val`)
        if (minStack.isEmpty() || `val` <= minStack.last()) {
            minStack.add(`val`)
        }
    }

    fun pop() {
        if (mainStack.isNotEmpty()) {
            val removed = mainStack.removeAt(mainStack.size - 1)
            if (removed == minStack.last()) {
                minStack.removeAt(minStack.size - 1)
            }
        }
    }

    fun top(): Int? {
        return mainStack.lastOrNull()
    }

    fun getMin(): Int? {
        return minStack.lastOrNull()
    }
}