class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var s = 0
        var e = nums.size - 1
        var m = 0
        while (s <= e) {
            m = (s + e) / 2
            if (nums[m] == target) {
                return m
            } else if (nums[m] > target) {
                e = m - 1
            } else {
                s = m + 1
            }
        }
        return if (nums[m] > target) m
        else m + 1
    }
}