class Solution {

    val answer = mutableListOf<List<Int>>()
    var combination = mutableListOf<Int>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        candidates.sort()

        recur(candidates, target, 0)

        return answer
    }

    fun recur(candidates: IntArray, lack: Int, idx: Int) {
        if (lack == 0) {
            answer.add(combination.toList())
            return
        }
        
        if (idx == candidates.size) {
            return
        }
        
        recur(candidates, lack, idx + 1)

        val candidate = candidates[idx]
        var addition = candidate
        while (addition <= lack) {
            combination.add(candidate)
            recur(candidates, lack - addition, idx + 1)
            addition += candidate
        }
        combination.removeAll { it == candidate }
    }
}