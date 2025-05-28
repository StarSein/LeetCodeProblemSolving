/**
 *
 * Time Complexity: O(M+N)
 * Fill nums1 from back to front.
 *
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var comparisonIndex1 = m - 1
        var comparisonIndex2 = n - 1
        for (insertionIndex in nums1.lastIndex downTo 0) {
            if (comparisonIndex1 == -1) {
                nums2.copyInto(
                    destination = nums1,
                    destinationOffset = 0,
                    startIndex = 0,
                    endIndex = comparisonIndex2 + 1
                )
                break
            } else if (comparisonIndex2 == -1) {
                break
            }
            val item1 = nums1[comparisonIndex1]
            val item2 = nums2[comparisonIndex2]
            if (item1 >= item2) {
                nums1[insertionIndex] = item1
                comparisonIndex1--
            } else {
                nums1[insertionIndex] = item2
                comparisonIndex2--
            }
        }
    }
}