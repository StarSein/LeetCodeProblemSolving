/**
 *
 * We should take account all possible lengths of the ranges that all '*' matches
 * With native Brute-Force, the time complexity is O(N^T)
 * (N = S.length, T = the number of '*')
 * With Dynamic Programming, the time complexity improves to O(NM)
 * (M = P.length)
 *
 */

class Solution {
    fun isMatch(s: String, p: String): Boolean {

        val cache = BooleanArray(s.length + 1) { false }
        // cache[i]: At the moment, whether the coverage of range [0:i) is possible or not.

        cache[0] = true

        for (c in p) {
            when (c) {
                '*' -> {
                    val firstTrueIndex = cache.indexOfFirst { it == true }
                    if (firstTrueIndex != -1) {
                        (firstTrueIndex + 1..<cache.size).forEach { cache[it] = true }
                    }
                }
                '?' -> {
                    cache[s.length] = false
                    for (i in s.length - 1 downTo 0) {
                        cache[i + 1] = cache[i]
                    }
                    cache[0] = false
                }
                else -> {
                    cache[s.length] = false
                    for (i in s.length - 1 downTo 0) {
                        cache[i + 1] = cache[i] && (c == s[i])
                    }
                    cache[0] = false
                }
            }
        }

        return cache[s.length]
    }
}
