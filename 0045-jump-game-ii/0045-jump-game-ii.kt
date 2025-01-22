import kotlin.math.min

/**
 *
 * Using Dynamic Programming,
 * we can track only optimal cases.
 * cache[i]: the minimum number of jumps to reach nums[i]
 * For simpler implementation and reducing overhead caused by repeated function call,
 * Take Bottom-Up approach.
 *
 * Time Complexity: O(NM)
 * (N is the length of nums, M is the max value of nums)
 * Memory Complexity: O(N)
 */

class Solution {

    val INF = 50_000

    fun jump(nums: IntArray): Int {

        val cache = IntArray(nums.size) { INF }

        cache[0] = 0
        for (i in nums.indices) {

            val jumpCapacity = nums[i]
            for (j in 1..jumpCapacity) {
                if (i + j >= nums.size) {
                    break
                }
                val k = i + j
                cache[k] = min(cache[k], cache[i] + 1)
            }
        }

        return cache[nums.size - 1]
    }
}