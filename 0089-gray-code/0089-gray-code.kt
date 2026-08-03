/**
 *
 * n <= 16
 * 2^n <= 64,000 < 100,000
 *
 * n=1
 * 0
 * 1
 *
 * n=2
 * 00 00
 * 01 10
 * 11 11
 * 10 01
 *
 * n=3
 * 000 000
 * 001 001
 * 101 011
 * 100 010
 * 110 110
 * 111 111
 * 011 101
 * 010 100
 *
 *
 * 1부터 (n/2)번째까지는 기존 수열을 가져와서 조건에 부합시키기
 * (n/2)번째와 (n/2+1)번째는 가장 오른쪽에 차이를 둬서 조건에 부합시키기
 * (n/2+1)번째부터 n번쨰까지는 기존 수열을 역순으로 가져와서 조건에 부합시키기
 *
 * 규칙에 따라 n=1부터 n=16까지 수열을 만들어도 원소의 개수는 2^17로 충분하다
 *
 * 시간 복잡도 O(2^N)
 * 공간 복잡도 O(2^N)
 *
 */


class Solution {

    fun recur(n: Int): List<Int> {
        if (n == 1) return listOf(0, 1)
        val prev = recur(n - 1)
        val left = prev.map { it shl 1 }
        val right = prev.reversed().map { it shl 1 or 1 }
        return left + right
    }

    fun grayCode(n: Int): List<Int> {
        return recur(n)
    }

}
