import kotlin.math.min

/**
 *
 * 1. The answer is same to the number of case
 *    that locate (m-1) `move down`s
 *    among (m+n-2) `move`s.
 *    Then, rest of `move`s will be the places of (n-1) `move right`s.
 *    So the answer is same to {m+n-2}_C_{m-1}.
 * 2. Calculate the value directly, as the answer is always bounded to Integer.
 *
 */


class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val x = m + n - 2
        val k = min(m, n) - 1

        var answer = 1L
        repeat(k) {
            answer *= (x - it)
            answer /= it + 1
        }
        return answer.toInt()
    }
}