class Solution {
    
    val answer = mutableListOf<List<Int>>()
    lateinit var src: IntArray
    lateinit var tgt: IntArray
    lateinit var selected: BooleanArray
    
    fun permute(nums: IntArray): List<List<Int>> {
        src = nums
        tgt = IntArray(nums.size)
        selected = BooleanArray(nums.size)
        
        recur(0)
        
        return answer
    }
    
    fun recur(depth: Int) {
        if (depth == src.size) {
            answer.add(tgt.toList())
            return
        }
        
        src.forEachIndexed { index, num ->
            if (!selected[index]) {
                tgt[depth] = num
                selected[index] = true
                
                recur(depth + 1)
                
                selected[index] = false
            }
        }
    }
}