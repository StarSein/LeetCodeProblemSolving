/**
 *
 * [불가능한 경우]
 * 1. 맨앞이 0으로 시작한다
 * 2. 30, 40, 50, ...
 * 3. 100, 200 또한 불가능
 *
 * [재귀 함수 + 메모이제이션]
 * 문자열 s의 현재 인덱스 i에 대해,
 * 폐구간 [0, i]를 디코딩하는 방법의 수를 dp[i]라고 하자.
 * s[i]와 s[i-1, i] 모두 한 개의 코드가 될 수 있는 경우 dp[i] = dp[i-2] + dp[i-1]
 * s[i]만 가능한 경우 dp[i] = dp[i-1]
 * s[i-1, i]만 가능한 경우 dp[i] = dp[i-2]
 * 둘 다 불가능한 경우 dp[i] = 0
 *
 */


class Solution {

    val dp = IntArray(100) { -1 }
    var msg = ""

    fun isDecodable(s: String): Boolean {
        if (s.startsWith('0')) return false
        if (s.toInt() > 26) return false
        return true
    }

    fun recur(i: Int): Int {
        if (i < -1) return 0
        if (i == -1) return 1
        if (dp[i] != -1) return dp[i]
        dp[i] = 0
        if (isDecodable(msg.substring(i, i + 1))) dp[i] += recur(i - 1)
        if (i > 0 && isDecodable(msg.substring(i - 1, i + 1))) dp[i] += recur(i - 2)
        return dp[i]
    }

    fun numDecodings(s: String): Int {
        msg = s
        return recur(msg.lastIndex)
    }
}