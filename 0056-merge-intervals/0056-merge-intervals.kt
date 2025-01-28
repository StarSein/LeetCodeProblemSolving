import kotlin.math.max

/**
 *
 * 1. Make an array which is sorted
 *    in ascending order using `start` value as a key.
 * 2. Iterate the array managing maximum value of `end`,
 *    and compare it with next `start` value
 *    to determine whether both are overlapping each other.
 */


class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        intervals.sortBy { interval -> interval[0] }

        val answer = mutableListOf<IntArray>()

        var mergedInterval = intervals[0]

        for (i in 1..intervals.lastIndex) {
            val currentInterval = intervals[i]
            if (mergedInterval[1] < currentInterval[0]) {
                answer.add(mergedInterval)
                mergedInterval = currentInterval
            } else {
                mergedInterval[1] = max(mergedInterval[1], currentInterval[1])
            }
        }
        answer.add(mergedInterval)
        
        return answer.toTypedArray()
    }
}