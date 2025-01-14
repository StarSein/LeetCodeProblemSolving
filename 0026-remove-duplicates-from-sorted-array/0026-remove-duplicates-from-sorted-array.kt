class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        
        var prev = 500
        val res = mutableListOf<Int>()
        for (cur in nums) {
            if (prev != cur) {
                res.add(cur)
                prev = cur
            }
        }
        
        res.forEachIndexed { index, it ->
            nums[index] = it
        }
        
        return res.size
    }
}