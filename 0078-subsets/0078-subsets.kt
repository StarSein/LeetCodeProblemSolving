class Solution {
    
    lateinit var src: IntArray
    val tgt = mutableListOf<Int>()
    val answer = mutableListOf<List<Int>>()
    
    fun subsets(nums: IntArray): List<List<Int>> {
        src = nums
        recur(0)
        return answer.toList()
    }
    
    fun recur(i: Int) {
        if (i == src.size) {
            answer.add(tgt.toList())
            return
        }
        
        recur(i + 1)
        
        tgt.add(src[i])
        recur(i + 1)
        tgt.removeLast()
    }
}