/**

 case 1. (0, 0, 0) :
    n(0) >= 3
 case 2. (0, +, -) :
    n(0) >= 1
    Find all the case with Time Complexity O(N)
 case 3. (+, +, -) or (+, -, -) :
    Find all the case with Time Complexity O(N^2)

 */

class Solution {

    var zeroCount = 0
    val duplicatedNumSet = mutableSetOf<Int>()
    val positiveNumSet = mutableSetOf<Int>()
    val negativeNumSet = mutableSetOf<Int>()

    fun threeSum(nums: IntArray): List<List<Int>> {

        val answer = mutableListOf<List<Int>>()

        for (num in nums) {
            if (num == 0) {
                zeroCount++
            } else if (num > 0) {
                if (positiveNumSet.contains(num)) {
                    duplicatedNumSet.add(num)
                }
                positiveNumSet.add(num)
            } else {
                if (negativeNumSet.contains(num)) {
                    duplicatedNumSet.add(num)
                }
                negativeNumSet.add(num)
            }
        }

        // case 1
        if (zeroCount >= 3) {
            answer.add(listOf(0, 0, 0))
        }

        // case 2
        if (zeroCount >= 1) {
            positiveNumSet
                .filter { positiveNum ->
                    negativeNumSet.contains(-positiveNum)
                }
                .forEach { positiveNum ->
                    answer.add(listOf(-positiveNum, 0, positiveNum))
                }
        }

        // case 3
        val pSize = positiveNumSet.size
        val pList = positiveNumSet.toList()
        for (i in 1 until pSize) {
            val pNum1 = pList[i]
            for (j in 0 until i) {
                val pNum2 = pList[j]
                val twoSum = pNum1 + pNum2
                if (negativeNumSet.contains(-twoSum)) {
                    answer.add(listOf(-twoSum, pNum1, pNum2))
                }
            }
        }
        for (pNum in pList) {
            if (duplicatedNumSet.contains(pNum) && negativeNumSet.contains(-2 * pNum)) {
                answer.add(listOf(-2 * pNum, pNum, pNum))
            }
        }

        val nSize = negativeNumSet.size
        val nList = negativeNumSet.toList()
        for (i in 1 until nSize) {
            val nNum1 = nList[i]
            for (j in 0 until i) {
                val nNum2 = nList[j]
                val twoSum = nNum1 + nNum2
                if (positiveNumSet.contains(-twoSum)) {
                    answer.add(listOf(-twoSum, nNum1, nNum2))
                }
            }
        }
        for (nNum in nList) {
            if (duplicatedNumSet.contains(nNum) && positiveNumSet.contains(-2 * nNum)) {
                answer.add(listOf(-2 * nNum, nNum, nNum))
            }
        }

        return answer
    }
}