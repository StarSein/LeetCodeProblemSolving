/**
 *
 * Time Complexity: O(N^3)
 *
 * Approach:
 * 1. cache[r][c]: maximum length of a vertical vector,
 *                 which consists of only '1',
 *                 where the '1' located on (r, c) is the bottom point of the vector.
 *
 * 2. maxArea(r, c) <- iterating from c to 0, update the minimum value 'M' of cache[r][i],
 *                                            update the maximum value of ((c - i + 1) * 'M')
 *
 */


class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val rSize = matrix.size
        val cSize = matrix[0].size
        val cache = Array(rSize) { IntArray(cSize) { 0 } }
        var answer = 0
        
        repeat(rSize) { r ->
            repeat(cSize) { c ->
                // calculate cache[r][c]
                cache[r][c] = if (matrix[r][c] == '1') {
                    1 + if (r == 0) 0 else cache[r - 1][c]
                } else {
                    0
                }

                // calculate maxArea(r, c) and update answer
                var minHeight = rSize
                (c downTo 0).forEach { i ->
                    minHeight = minOf(minHeight, cache[r][i])
                    if (minHeight == 0) return@forEach
                    answer = maxOf(answer, (c - i + 1) * minHeight)
                }
            }
        }

        return answer
    }
}