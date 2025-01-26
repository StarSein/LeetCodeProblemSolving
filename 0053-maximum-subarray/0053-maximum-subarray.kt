import kotlin.math.max

/**
 *
 * 1. Iterate the array left to right.
 * 2. As soon as a subarray with range[s:e] of which sum is negative,
 *    remove the range.
 * 3. Because there is no `i` that makes range[i:e]'s sum is bigger than range[s:e] ( i < s ),
 *    the removal is logically consistent to find the optimal range.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.all { it < 0 }) {
            return nums.max()
        }
        
        var answer = 0
        var curSum = 0
        nums.forEach { num ->
            if (curSum + num < 0) {
                curSum = 0
            } else {
                curSum += num
            }
            answer = max(answer, curSum)
        }
        return answer
    }
}