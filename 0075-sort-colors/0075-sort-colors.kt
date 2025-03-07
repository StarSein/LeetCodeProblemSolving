/**
 *
 * Constraint: One-Pass Algorithm
 *             with Constant Extra Space
 *
 * [2,0,2,1,1,0] i s e n
 * [X,0,2,1,1,X](0,1,4,0)
 * [X,X,2,1,1,X](1,2,4,0)
 * [X,X,?,1,X,X](2,2,3,1)
 * [X,X,?,?,X,X](3,2,3,2)
 *
 * [2,0,1] i s e n
 * [?,0,X](0,0,1,1)
 * [X,?,X](1,1,1,1)
 *
 * [0,1,2,1,1] i s e n
 * [X,1,2,1,1](0,1,4,0)
 * [X,?,2,1,1](1,1,4,1)
 * [X,?,?,1,X](2,1,3,2)
 * [X,?,?,?,X](3,1,3,3)
 *
 *                  i  s  e  n
 * [1,2,0,2,0,2,1] ( , 0, 6, 0)
 * [?,2,0,2,0,2,1] (0, 0, 6, 1)
 * [?,?,0,2,0,2,2] (1, 0, 4, 2)
 * [0,?,?,2,0,2,2] (2, 1, 4, 2)
 * [0,0,?,?,2,2,2] (3, 2, 3, 2)
 *
 * [1,1,1,2,2,0,2,0,2,2,1,1,1] i  s  e  n
 *  ?                          0  0 12  1
 *    ?                        1  0 12  2
 *      ?                      2  0 12  3
 *        ?                 X  3  0 11  4
 *          ?             X    4  0 10  5
 *  X         ?                5  1 10  5
 *              ?   X X X      6  1  7  6
 *    X           ?            7  2  7  6
 *      X X X X X X
 *
 * Solution:
 *  Use 4 variables
 *     1) i: index of nums for iteration from first to last
 *     2) s: index where a newly found '0' can place in
 *     3) e: index where a newly found '2' can place in
 *     4) n: the number of found '1' until now
 *
 */

class Solution {
    fun sortColors(nums: IntArray): Unit {
        var i = 0
        var s = 0
        var e = nums.lastIndex
        var n = 0
        while (e - s + 1 > n) {
            if (nums[e] == 2) {
                e--
                continue
            }
            val left = nums[i]
            nums[i++] = 1
            when (left) {
                0 -> { nums[s++] = 0 }
                1 -> { n++ }
                2 -> {
                    val right = nums[e]
                    when (right) {
                        0 -> { nums[s++] = 0 }
                        1 -> { n++ }
                    }
                    nums[e--] = 2
                }
            }
        }
    }
}