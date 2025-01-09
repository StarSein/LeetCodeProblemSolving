import kotlin.math.max

/**

 1. Moving right column of the container, find the optimal left column among the columns we have met before.
 2. In this approach, we can figure out there is no possibility to use a column which is smaller than other which locates on the left side of it.
 3. So, when storing all the height of the column we have met in a queue, the queue could be sorted in ascending order.
 4. But in this approach, if the heights are already sorted in ascending order, there is no improvement in terms of time complexity,
    because it is still O(N^2)
 5. Besides, pivoting the tallest column, make the left side in ascending order, the right side in descending order.
 6. Then, we can find the best case in time complexity of O(N).

 */

class Solution {
    fun maxArea(height: IntArray): Int {

        // find the maxHeight
        val maxHeight = height.max()

        // from left side, make ascending list until meeting the maxHeight first
        val size = height.size
        val lefts = MutableList(1) { 0 to height[0] }
        for (i in 1..<size) {
            val curHeight = height[i]

            if (curHeight > lefts.last().second) {
                lefts.add(i to curHeight)
            }

            if (curHeight == maxHeight) {
                break
            }
        }

        // from right side, make ascending list until meeting the maxHeight first
        val rights = MutableList(1) { size - 1 to height[size - 1] }
        for (i in size - 2 downTo 0) {
            val curHeight = height[i]

            if (curHeight > rights.last().second) {
                rights.add(i to curHeight)
            }

            if (curHeight == maxHeight) {
                break
            }
        }

        // moving pointers of the two list, find the answer
        var answer = 0
        var l = 0
        var r = 0
        while (l < lefts.size && r < rights.size) {
            val (lx, ly) = lefts[l]
            val (rx, ry) = rights[r]

            var area: Int
            if (ly >= ry) {
                area = (rx - lx) * ry
                r++
            } else {
                area = (rx - lx) * ly
                l++
            }
            answer = max(answer, area)
        }

        return answer
    }
}