class Solution {
   fun moveZeroes(nums: IntArray) {
       
        val zeroCount = nums.filter { it == 0 }.count()
        var last = 0

        repeat(zeroCount) {
            for (i in 0..nums.lastIndex - last)
            //nums.forEachIndexed { index, i ->
                if (nums[i] == 0) {
                    if (i != nums.lastIndex) {
                        nums[i] = nums[i + 1]
                        nums[i + 1] = i
                    }
                }
            last++
        }
   }
}
