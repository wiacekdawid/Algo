package `75plan`.stack

import java.util.*
import kotlin.math.abs

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode. If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 */

class AsteroidCollision {
    // time / space O(n)
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        asteroids.forEach {
            var pushFlag = true
            while (stack.isNotEmpty() && stack.peek() > 0 && it < 0) {
                if (abs(stack.peek()) < abs(it)) {
                    stack.pop()
                    continue
                }

                if (abs(stack.peek()) == abs(it)) {
                    stack.pop()
                }

                pushFlag = false
                break
            }

            if (pushFlag) {
                stack.push(it)
            }
        }

        val result = IntArray(stack.size)

        for ( i in result.size-1 downTo 0) {
            result[i] = stack.pop()
        }

        return result
    }
}