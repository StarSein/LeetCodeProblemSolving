class Solution {

    val answer = mutableListOf<List<Int>>()
    val comb = mutableListOf<Int>()
    var N = -1
    var K = -1
    
    fun combine(n: Int, k: Int): List<List<Int>> {
        N = n
        K = k
        recur(0, 1)
        return answer.toList()
    }

    fun recur(i: Int, s: Int) {
        if (i == K) {
            answer.add(comb.toList())
            return
        }
        if (s > N) {
            return
        }
        (s..N).forEach {
            comb.add(it)
            recur(i + 1, it + 1)
            comb.removeLast()
        }
    }
}