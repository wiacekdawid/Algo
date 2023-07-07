package `75plan`.stack

import java.util.*

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode. If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 */

class AsteroidCollision {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val result = IntArray(asteroids.size)
        val stack = Stack<Int>()
        asteroids.forEach {
            if (it >= 0) {
                stack.push(it)
            } else {
                while(stack.isNotEmpty()) {
                    val leftAstro = stack.pop()
                    if (leftAstro < 0) {

                    }
                }
            }
        }
        return result
    }
}