import kotlin.math.max
import kotlin.math.min

/**
 *
 * 1. Define:
 *  1) rainHeight[i]: the height of the rain trapped on x = i
 *  2) wallHeight[i]: the height of the wall on x = i
 *  3) leftMaxWallHeight[i]: the height of the tallest wall among all walls on x < i
 *  4) rightMaxWallHeight[i]: the height of the tallest wall among all walls on x > i
 * 2. Formula:
 *  1) rainHeight[i] = max(
 *      min(leftMaxWallHeight[i], rightMaxWallHeight[i]) - wallHeight[i],
 *      0
 *     )
 *
 * 3. Time Complexity: O(N)
 * 4. Space Complexity: O(N)
 */

class Solution {
    fun trap(height: IntArray): Int {
        // Applying prefix sum, calculate left and right max wall heights
        val leftMaxWallHeights = IntArray(height.size) { 0 }
        for (i in 1..<height.size) {
            leftMaxWallHeights[i] = max(height[i - 1], leftMaxWallHeights[i - 1])
        }
        
        val rightMaxWallHeights = IntArray(height.size) { 0 }
        for (i in height.size - 2 downTo 1) {
            rightMaxWallHeights[i] = max(height[i + 1], rightMaxWallHeights[i + 1])
        }
        
        // According to the formula, calculate the amount of the rain trapped
        val answer = (0..<height.size).sumOf {
            max(
                min(leftMaxWallHeights[it], rightMaxWallHeights[it]) - height[it],
                0
            )
        }
        
        // return the calculated value
        return answer
    }
}