class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val missed = BooleanArray(100_002) { true }
        
        nums.forEach { nums ->
            if (nums in 1..<missed.size) {
                missed[nums] = false
            }
        }

        return (1..<missed.size).first { missed[it] }
    }
}