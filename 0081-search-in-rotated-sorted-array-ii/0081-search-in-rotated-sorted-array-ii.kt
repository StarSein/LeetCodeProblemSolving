class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        // Find the range [s, e] where next binary search can be done
        val tgt = nums[0]
        var s = nums.indexOfFirst { it != tgt }
        if (s == -1) {
            return tgt == target
        }
        var e = nums.indexOfLast { it != tgt }

        // Find the pivot `k` using binary search
        val k = {
            while (s <= e) {
                val m = (s + e) / 2
                if (nums[m] >= tgt) {
                    s = m + 1
                } else {
                    e = m - 1
                }
            }
            e
        }.invoke()

        // Find the target using binary search
        val answer = lambda@ {
            var (s, e) = if (target >= nums[0]) 0 to k
            else k + 1 to nums.lastIndex
            
            while (s <= e) {
                val m = (s + e) / 2
                if (nums[m] == target) {
                    return@lambda true
                } else if (nums[m] > target) {
                    e = m - 1
                } else {
                    s = m + 1
                }
            }
            return@lambda false
        }

        return answer.invoke()
    }
}