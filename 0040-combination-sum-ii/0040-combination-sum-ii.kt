class Solution {
    
    class Counter(
        val candidate: Int,
        val count: Int
    )
    
    lateinit var counters: List<Counter>
    
    val answer = mutableListOf<List<Int>>()
    val combination = mutableListOf<Int>()
    
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        
        counters = candidates.groupBy { it }
            .mapValues { it.value.size }
            .map { Counter(
                candidate = it.key, 
                count = it.value
            ) }
        
        recur(0, target)
        
        return answer
    }
    
    fun recur(idx: Int, target: Int) {
        if (target == 0) {
            answer.add(combination.toList())
            return
        }
        
        if (idx == counters.size) {
            return
        }
        
        recur(idx + 1, target)
        
        with (counters[idx]) {
            var addition = candidate
            var cnt = 1
            while (addition <= target && cnt <= count) {
                combination.add(candidate)
                
                recur(idx + 1, target - addition)
                
                addition += candidate
                cnt++
            }
            combination.removeAll { it == candidate }
        }
    }
}