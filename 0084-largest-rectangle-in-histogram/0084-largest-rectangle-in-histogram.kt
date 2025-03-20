import kotlin.collections.ArrayDeque
import kotlin.math.max
import kotlin.math.min

/**
 *
 * Use a stack.
 * If current bar's height is lower than the top of the stack,
 * the top element have not to be maintained in the stack.
 * So, it is valid to remove the element and calculate the area with its height and x coordinate.
 * Repeat the same task while the stack has no bar which is taller than current bar.
 * As the series of the stack elements' height keeps ascending order,
 * the bar height being removed from the stack can be multiplied by width.
 * (Because it is assured there is not lower bar in the range)
 *
 * All bars would be accessed once, being popped once, and being used on calculation once.
 * Thus, the time complexity is O(N)
 */

class Solution {

    fun largestRectangleArea(heights: IntArray): Int {
        var answer = 0
        val st = ArrayDeque<Pair<Int, Int>>()

        heights.forEachIndexed loop@ { curX, curHeight ->
            var minX = curX
            while (st.isNotEmpty() && st.last().second > curHeight) {
                val (prevX, prevHeight) = st.removeLast()
                val area = (curX - prevX) * prevHeight
                minX = prevX
                answer = max(answer, area)
            }
            if (st.isNotEmpty() && st.last().second == curHeight) {
                return@loop
            }
            st.addLast(Pair(minX, curHeight))
        }

        val curX = heights.size
        while (st.isNotEmpty()) {
            val (prevX, prevHeight) = st.removeLast()
            val area = (curX - prevX) * prevHeight
            answer = max(answer, area)
        }

        return answer
    }
}