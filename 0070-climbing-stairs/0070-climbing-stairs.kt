/**
 *
 * f(n) = f(n - 1) + f(n - 2)
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 */


class Solution {

    lateinit var cache: IntArray

    fun climbStairs(n: Int): Int {

        cache = IntArray(n + 1)

        return fibonacci(n)
    }

    fun fibonacci(x: Int): Int {
        if (x <= 1) {
            return 1
        }

        cache[x].let {
            if (it != 0) {
                return it
            }
        }

        return (fibonacci(x - 1) + fibonacci(x - 2)).also {
            cache[x] = it
        }
    }
}