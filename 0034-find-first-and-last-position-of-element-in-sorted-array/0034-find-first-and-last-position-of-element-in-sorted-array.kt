class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(
            findStartingIndex(nums, target),
            findEndingIndex(nums, target)
        )
    }

    fun findStartingIndex(nums: IntArray, target: Int): Int {
        var ret = -1
        var s = 0
        var e = nums.size - 1
        while (s <= e) {
            val m = (s + e) / 2
            if (nums[m] == target) {
                ret = m
                e = m - 1
            } else if (nums[m] > target) {
                e = m - 1
            } else {
                s = m + 1
            }
        }
        return ret
    }

    fun findEndingIndex(nums: IntArray, target: Int): Int {
        var ret = -1
        var s = 0
        var e = nums.size - 1
        while (s <= e) {
            val m = (s + e) / 2
            if (nums[m] == target) {
                ret = m
                s = m + 1
            } else if (nums[m] > target) {
                e = m - 1
            } else {
                s = m + 1
            }
        }
        return ret
    }
}