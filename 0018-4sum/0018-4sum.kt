/**

 Brute force with Time Complexity of O(N^3 * logN)

 */

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val tl = target.toLong()
        
        val answer = mutableSetOf<List<Int>>()

        nums.sort()

        for (i in 2 until nums.size - 1) {
            val c = nums[i]
            for (j in 1 until i) {
                val b = nums[j]
                for (k in 0 until j) {
                    val a = nums[k]
                    var l = i + 1
                    var r = nums.size - 1
                    while (l <= r) {
                        val m = (l + r) / 2
                        val d = nums[m]
                        val fourSum = a.toLong() + b + c + d
                        if (fourSum == tl) {
                            answer.add(listOf(a, b, c, d))
                            break
                        } else if (fourSum > tl) {
                            r = m - 1
                        } else {
                            l = m + 1
                        }
                    }
                }
            }
        }

        return answer.toList()
    }
}