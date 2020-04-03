class Solution {
   fun maxSubArray(nums: IntArray): Int {
        return if (nums.size == 1)
            nums.first()
        else {
            var currentMax = nums.first()
            var superMax = nums.first()
            for (i in 1..nums.lastIndex) {
                currentMax = Math.max(currentMax + nums[i], nums[i])
                superMax = Math.max(superMax, currentMax)
            }
            superMax
        }
    }
}
