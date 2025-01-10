import kotlin.math.abs

/**
 X = | a + b + c - target |
 find the smallest value of X.
 
 Suppose that a <= b <= c
 Pick all possible (a, b) with Time Complexity of O(N^2)
 Do binary search to find c on each (a, b) with Time Complexity of O(logN)
 Y = target - (a + b)
 c is 1) the smallest value bigger than Y
      2) the biggest value smaller than Y
 */

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        
        nums.sort()
        
        val candidates = mutableListOf<Int>()
        
        for (i in 1..nums.size - 2) {
            for (j in 0..<i) {
                var l = i + 1
                var r = nums.size - 1
                var pos = r
                while (l <= r) {
                    val m = (l + r) / 2
                    if (nums[i] + nums[j] + nums[m] >= target) {
                        pos = m
                        r = m - 1
                    } else {
                        l = m + 1
                    }
                }
                candidates.add(nums[i] + nums[j] + nums[pos])
                
                l = i + 1
                r = nums.size - 1
                pos = l
                while (l <= r) {
                    val m = (l + r) / 2
                    if (nums[i] + nums[j] + nums[m] <= target) {
                        pos = m
                        l = m + 1
                    } else {
                        r = m - 1
                    }
                }
                candidates.add(nums[i] + nums[j] + nums[pos])
            }
        }
        
        val answer = candidates.reduce { acc, it -> 
            if (abs(acc - target) < abs(it - target)) acc 
            else it 
        }
        
        return answer
    }
}