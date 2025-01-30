import kotlin.math.min

/**
 *
 * f(r, c): minimum path sum of a path from (0, 0) to (r, c)
 * f(r, c) = grid[r][c] + min(f(r-1,c), f(r,c-1))
 *
 * Time Complexity: O(MN)
 * Space Complexity: O(MN)
 *
 */


class Solution {

    val INF = 1_000_000_000
    lateinit var grid: Array<IntArray>
    lateinit var cache: Array<IntArray>

    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        this.grid = grid
        cache = Array(m) { IntArray(n) { -1 } }
        cache[0][0] = grid[0][0]
        
        return f(m - 1, n - 1)
    }
    
    fun f(r: Int, c: Int): Int {
        if (r == -1 || c == -1) {
            return INF
        }
        cache[r][c].let {
            if (it != -1) {
                return it
            }
        }
        return (grid[r][c] + min(f(r - 1, c), f(r, c - 1))).also {
            cache[r][c] = it
        }
    }
}