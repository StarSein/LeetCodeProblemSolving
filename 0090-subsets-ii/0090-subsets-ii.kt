class Solution {

    val counts = IntArray(21)
    val subset = ArrayList<Int>(10)
    val answer = mutableListOf<List<Int>>()

    fun recur(n: Int) {
        if (n == counts.size) {
            answer.add(subset.toList())
            return
        }
        recur(n + 1)
        repeat(counts[n]) {
            subset.add(n - 10)
            recur(n + 1)
        }
        repeat(counts[n]) {
            subset.removeLast()
        }
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.forEach { num -> counts[num + 10]++ }

        recur(0)

        return answer.toList()
    }
}
