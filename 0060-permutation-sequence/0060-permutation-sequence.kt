/**
 *
 * 1. (k-1) 를 x_0 * (n-1)! + x_1 * (n-2)! + ... + x_k 로 나타낼 수 있다
 *   (0 <= x < n)
 * 2. 그러면 순열의 k번째 인덱스 이전에 등장하지 않은 수들 중
 *   (x_k + 1)번째로 작은 수가 k번째 인덱스에 위치하게 된다
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 *
 */


class Solution {
    fun getPermutation(n: Int, k: Int): String {

        val nums = MutableList(n) { it + 1 }
        var p = 1
        val perms = IntArray(n - 1) {
            p *= it + 1
            p
        }
        // perm[i]: (i + 1)!

        val answer = StringBuilder()

        var count = k - 1
        (n - 2 downTo 0).forEach {
            val perm = perms[it]
            val index = count / perm
            val num = nums[index]

            answer.append(num)
            nums.removeAt(index)

            count -= index * perm
        }
        answer.append(nums[0])

        return answer.toString()
    }
}