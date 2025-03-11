class Solution {

    val visited = Array(6) { BooleanArray(6) { false } }
    val dr = arrayOf(0, 1, 0, -1)
    val dc = arrayOf(1, 0, -1, 0)
    var m = -1
    var n = -1
    var sz = -1
    lateinit var grid: Array<CharArray>
    lateinit var w: String

    fun exist(board: Array<CharArray>, word: String): Boolean {
        grid = board
        w = word
        m = board.size
        n = board[0].size
        sz = word.length
        for ((r, row) in board.withIndex()) {
            for ((c, item) in row.withIndex()) {
                if (item == word[0]) {
                    visited[r][c] = true
                    if (recur(1, r, c)) return true
                    visited[r][c] = false
                }
            }
        }
        return false
    }

    fun recur(i: Int, r: Int, c: Int): Boolean {
        if (i == sz) {
            return true
        }
        repeat(4) lambda@{ d ->
            val nr = r + dr[d]
            val nc = c + dc[d]
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) return@lambda
            if (grid[nr][nc] != w[i]) return@lambda
            if (visited[nr][nc]) return@lambda
            visited[nr][nc] = true
            if (recur(i + 1, nr, nc)) return true
            visited[nr][nc] = false
        }
        return false
    }
}