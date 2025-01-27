/**
 *
 * Time Complexity: O(NM)
 * Space Complexity: O(NM)
 *
 */

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        
        val m = matrix.size
        val n = matrix[0].size
        
        val dr = arrayOf(0, 1, 0, -1)
        val dc = arrayOf(1, 0, -1, 0)
        var r = 0
        var c = 0
        var d = 0
        val visited = Array(m) { BooleanArray(n) }
        
        return List(m * n) {
            matrix[r][c].also {
                visited[r][c] = true
                val nr = r + dr[d]
                val nc = c + dc[d]
                if (nr in 0..<m && nc in 0..<n && !visited[nr][nc]) {
                    r = nr
                    c = nc
                } else {
                    d = (d + 1) % dr.size
                    r += dr[d]
                    c += dc[d]
                }
            }
        }
        
    }
}