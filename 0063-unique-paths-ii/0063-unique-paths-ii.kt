/**
 *
 * cache[r][c]: the number of possible unique paths from (0, 0) to (r, c)
 * cache[r][c] = cache[r - 1][c] + cache[r][c - 1]
 *
 * Time Complexity: O(MN)
 * Space Complexity: O(MN)
 *
 */

class Solution {

    lateinit var grid: Array<IntArray>
    lateinit var cache: Array<IntArray>

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size

        grid = obstacleGrid
        cache = Array(m) { IntArray(n) { -1 } }
        cache[0][0] = 1
        return recur(m - 1, n - 1)
    }

    fun recur(r: Int, c: Int): Int {
        if (r == -1 || c == -1 || grid[r][c] == 1) {
            return 0
        }
        
        cache[r][c].let {
            if (it != -1) {
                return it
            }
        }
        return (recur(r - 1, c) + recur(r, c - 1)).also {
            cache[r][c] = it
        }
    }
}