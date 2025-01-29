/**
 * 
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 * 
 */


class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {

        val answer = Array(n) { IntArray(n) }
        val dr = arrayOf(0, 1, 0, -1)
        val dc = arrayOf(1, 0, -1, 0)
        
        var r = 0
        var c = 0
        var d = 0
        
        repeat(n * n) { 
            answer[r][c] = it + 1
            
            val nr = r + dr[d]
            val nc = c + dc[d]
            if (nr in 0..<n && nc in 0..<n && answer[nr][nc] == 0) {
                r = nr
                c = nc
            } else {
                d = (d + 1) % 4
                r += dr[d]
                c += dc[d]
            }
        }
        
        return answer
    }
}