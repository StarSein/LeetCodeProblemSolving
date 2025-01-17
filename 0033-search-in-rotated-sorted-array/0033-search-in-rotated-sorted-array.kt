/**
 * Suppose that p < q < r < s
 *
 * All possible cases of nums are categorized into two types.
 * type 1. [p, ..., s]
 *
 * type 2. [r, ..., s, p, ..., q]
 *
 * 1. Distinguish Type: compare the first and last element.
 *  if first is smaller than last, it is type 1,
 *  otherwise, type 2.
 * 2. Find target
 *  type 1) normal binary search
 *  type 2)
 *    (1) find the subarray where the target exists
 *      - find the index where the value is smaller than its left item's value
 *      - use binary search
 *      - if nums[i] is bigger than r, search the range of [i + 1:]
 *        otherwise, search the range of [:i]
 *      - if target is bigger than r, subarray is the left side of the index
 *        otherwise, the right side of the index
 *    (2) normal binary search on the subarray
 */

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        // 1. distinguish type
        if (nums.first() <= nums.last()) { // considering the case where nums.length is 1
            return binarySearch(nums, target, 0, nums.size - 1)
        }
        
        // 2. find target
        // 2-(1)
        var s = 0
        var e = nums.size - 1
        var i = -1
        while (s <= e) {
            val m = (s + e) / 2
            if (nums[m] > nums[m + 1]) {
                i = m
                break
            }
            if (nums[m] >= nums.first()) {
                s = m + 1
            } else {
                e = m - 1
            }
        }
        
        val (start, end) = if (target >= nums.first()) 0 to i
                           else i + 1 to nums.size - 1
        
        // 2-(2)
        return binarySearch(nums, target, start, end)
    }
    
    fun binarySearch(nums: IntArray, target: Int, start: Int, end: Int): Int {
        var s = start
        var e = end
        while (s <= e) {
            val m = (s + e) / 2
            if (nums[m] == target) {
                return m
            } else if (nums[m] > target) {
                e = m - 1
            } else {
                s = m + 1
            }
        }
        return -1
    }
}