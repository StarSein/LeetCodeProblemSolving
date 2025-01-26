import kotlin.math.max

/**
 *
 * Manage a segment's state with four properties
 * to find the max value of sum of the subarray.
 *  1) leftMaxSum: the max value of sum of the subarray which contains the leftmost element.
 *  2) rightMaxSum: the max value of sum of the subarray which contains the rightmost element.
 *  3) entireSum: the sum of the segment
 *  4) maxSum: the max value of sum of the subarray in the segment
 *
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 *
 */

class Solution {

    class Segment(
        val leftMaxSum: Int,
        val rightMaxSum: Int,
        val entireSum: Int,
        val maxSum: Int
    )

    fun maxSubArray(nums: IntArray): Int {
        return dnc(nums, 0, nums.lastIndex).maxSum
    }

    fun dnc(nums: IntArray, startIndex: Int, lastIndex: Int): Segment {
        if (startIndex == lastIndex) {
            val num = nums[startIndex]
            return Segment(
                leftMaxSum = num,
                rightMaxSum = num,
                entireSum = num,
                maxSum = num
            )
        }

        val midIndex = (startIndex + lastIndex) / 2

        val leftSeg = dnc(nums, startIndex, midIndex)
        val rightSeg = dnc(nums, midIndex + 1, lastIndex)

        val leftMaxSum = max(leftSeg.leftMaxSum, leftSeg.entireSum + rightSeg.leftMaxSum)
        val rightMaxSum = max(rightSeg.rightMaxSum, leftSeg.rightMaxSum + rightSeg.entireSum)
        val entireSum = leftSeg.entireSum + rightSeg.entireSum
        val maxSum = arrayOf(
            leftSeg.maxSum,
            rightSeg.maxSum,
            leftMaxSum,
            rightMaxSum,
            leftSeg.rightMaxSum + rightSeg.leftMaxSum
        ).max()

        return Segment(
            leftMaxSum = leftMaxSum,
            rightMaxSum = rightMaxSum,
            entireSum = entireSum,
            maxSum = maxSum
        )
    }
}
