import kotlin.math.max

/**
 *
 * Managing max value of spare jump length,
 * iterate the array from left to right.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 */


class Solution {
    fun canJump(nums: IntArray): Boolean {

        var spareJumpLength = nums[0]

        for (i in 1..nums.lastIndex) {
            if (spareJumpLength == 0) {
                return false
            }
            spareJumpLength = max(spareJumpLength - 1, nums[i])
        }

        return true
    }
}