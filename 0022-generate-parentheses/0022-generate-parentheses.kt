/**

 Generate all the cases with brute-forcing 0-1 subsets.
 Time Complexity: O(2^N)

 */

class Solution {

    val answer = mutableListOf<String>()
    lateinit var tgt: Array<Char>

    fun generateParenthesis(n: Int): List<String> {
        tgt = Array(2 * n) { ' ' }

        recur(0, n, 0)

        return answer
    }

    fun recur(idx: Int, openCntUnused: Int, openCntUnpaired: Int) {
        if (idx == tgt.size) {
            answer.add(tgt.joinToString(""))
            return
        }

        if (openCntUnused > 0) {
            tgt[idx] = '('
            recur(idx + 1, openCntUnused - 1, openCntUnpaired + 1)
        }
        if (openCntUnpaired > 0) {
            tgt[idx] = ')'
            recur(idx + 1, openCntUnused, openCntUnpaired - 1)
        }
    }
}