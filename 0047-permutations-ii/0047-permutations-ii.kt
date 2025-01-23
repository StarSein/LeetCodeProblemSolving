class Solution {

    val answer = mutableListOf<List<Int>>()
    lateinit var src: IntArray
    lateinit var tgt: IntArray
    lateinit var selected: BooleanArray

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        
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

        var lastSelectedNum = 100

        src.forEachIndexed { index, num ->
            if (!selected[index] && lastSelectedNum != num) {
                selected[index] = true
                tgt[depth] = num

                recur(depth + 1)

                selected[index] = false
                lastSelectedNum = num
            }
        }
    }
}