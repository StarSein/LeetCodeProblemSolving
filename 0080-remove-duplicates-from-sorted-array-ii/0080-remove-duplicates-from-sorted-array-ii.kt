class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var pos = 0
        var dupCount = 0
        var prevNum = -10_001
        nums.forEachIndexed { index, num ->
            if (num == prevNum) {
                if (++dupCount == 1) {
                    nums[pos++] = num
                }
            } else {
                nums[pos++] = num
                dupCount = 0
                prevNum = num
            }
        }
        return pos
    }
}