class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val res = nums.filter { it != `val` }
        
        res.forEachIndexed { index, it ->
            nums[index] = it 
        }
        
        return res.size
    }
}