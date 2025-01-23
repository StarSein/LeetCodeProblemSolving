class Solution {
    
    val answer = mutableSetOf<List<Int>>()
    lateinit var src: IntArray
    lateinit var tgt: IntArray
    lateinit var selected: BooleanArray
    
    fun permuteUnique(nums: IntArray): List<List<Int>> {

        src = nums
        tgt = IntArray(nums.size)
        selected = BooleanArray(nums.size)
        
        recur(0)
        
        return answer.toList()
    }
    
    fun recur(depth: Int) {
        if (depth == src.size) {
            answer.add(tgt.toList())
            return
        }
        
        src.forEachIndexed { index, num ->
            if (!selected[index]) {
                selected[index] = true
                tgt[depth] = num
                
                recur(depth + 1)
                selected[index] = false
            }
        }
    }
}