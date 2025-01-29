/**
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 */


class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        val answer = mutableListOf<IntArray>()

        var minS = 1_000_000
        var maxE = -1
        var overlapping = false
        var isOverlapped = false

        intervals.forEach { interval ->
            if (isOverlapping(interval, newInterval)) {
                minS = arrayOf(interval[0], newInterval[0], minS).min()
                maxE = arrayOf(interval[1], newInterval[1], maxE).max()
                overlapping = true
                isOverlapped = true
            } else {
                if (overlapping) {
                    answer.add(intArrayOf(minS, maxE))
                    overlapping = false
                }
                answer.add(interval)
            }
        }
        if (overlapping) {
            answer.add(intArrayOf(minS, maxE))
        }

        if (!isOverlapped) {
            val index = answer.indexOfFirst { it[0] > newInterval[0] }
            if (index == -1) {
                answer.add(newInterval)
            } else {
                answer.add(index, newInterval)
            }
        }

        return answer.toTypedArray()
    }

    fun isOverlapping(a: IntArray, b: IntArray): Boolean {
        return a[0] in b[0]..b[1] 
                || a[1] in b[0]..b[1]
                || b[0] in a[0]..a[1]
                || b[1] in a[0]..a[1]
    }
}