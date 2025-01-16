/**
 *
 * 35142
 * -> 352'41' -> 35214
 * 
 * 35241
 * -> 354'21' -> 35412
 *
 * 1234987654321
 * -> 1235'987644321' -> 1235123446789
 *
 * 175869
 * -> 175896
 * -> 1759'86' -> 175968
 * -> 175986
 * -> 176'985' -> 176589
 * 
 * 176985
 * -> 178'965' -> 178569
 * 
 * 1. A가 B의 Next Permutation이라고 하자.
 *    A는 B보다 사전식으로 뒤에 오는 순열들 중 가장 앞에 있는 순열이다.
 * 2. A를 만들기 위해, B의 맨 마지막(오른쪽)부터 훑어보는데,
 *    어떤 수 r의 바로 왼쪽에 있는 수 l에 대해, l < r 이 성립한다면 l의 위치에 l보다 큰 수 x가 와야할 차례가 된 것이다.
 * 3. 그 수 x는 구간 [r의 위치, 마지막 위치]에서 가져와야 하는데,
 *    결국 맨 마지막부터 훑어보면서 l보다 큰 수가 나타나면, 
 *    바로 그 수가 x가 되어야 한다. 그리고 l은 원래 x가 있던 자리에 들어가야 한다.
 * 4. 이 경우에도 여전히 구간 [r의 위치, 마지막 위치]는 내림차순으로 나열되어 있다.
 *    이 구간을 좌우로 뒤집어 주면 A가 만들어진다.
 * 5. 만약 l < r 이 성립하는 지점이 없으면, B는 맨 뒤에 오는 순열로서,
 *    A는 맨 앞에 오는 순열, 즉 B의 모든 구간을 좌우로 뒤집은 것이 된다.
 */

class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        // nums의 맨 뒤부터 순회하면서
        // (l < r)이 성립하는 지점에서 l의 위치를 p라고 한다
        val size = nums.size
        val p = (size - 2 downTo 0).firstOrNull { nums[it] < nums[it + 1]}
        
        // p가 없는 경우
        // nums의 전 구간을 좌우로 뒤집고 함수를 종료한다
        if (p == null) {
            nums.reverse()
            return
        }
        
        // nums의 맨 뒤부터 순회하면서
        // l보다 큰 수 x가 발견되면, 그 위치를 q라고 한다
        val l = nums[p]
        val q = (size - 1 downTo p + 1).first { nums[it] > l }

        // p와 q의 수를 서로 바꾼다
        swap(nums, p, q)

        // 구간 [p+1:]을 좌우로 뒤집고 함수를 종료한다 
        var s = p + 1
        var e = size - 1
        while (s < e) {
            swap(nums, s++, e--)
        }
    }
    
    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}