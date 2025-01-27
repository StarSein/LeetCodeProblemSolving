/**
 *
 * Time Complexity: O(N^3)
 * Space Complexity: O(N)
 *
 */


class Solution {
    fun isMatch(s: String, p: String): Boolean {

        val cache = BooleanArray(s.length + 1)
        // cache[i]: whether it is possible to match s[:i] with iterated substring of p at the moment.
        cache[0] = true

        for (i in p.indices) {
            if (p[i] == '*') {
                continue
            }

            if (i < p.lastIndex && p[i + 1] == '*') {
                for (j in s.lastIndex downTo 0) {
                    if (cache[j]) {
                        var k = j
                        while (k <= s.lastIndex && match(s[k], p[i])) {
                            cache[k + 1] = true
                            k++
                        }
                    }
                }
            } else {
                cache[cache.lastIndex] = false
                for (j in s.lastIndex downTo 0) {
                    cache[j + 1] = cache[j] && match(s[j], p[i])
                }
                cache[0] = false
            }
        }

        return cache[cache.lastIndex]
    }

    fun match(si: Char, pi: Char): Boolean {
        return pi == '.' || si == pi
    }
}