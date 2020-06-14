class Solution {
      fun climbStairs(n: Int): Int {
       return when (n) {
            1 -> n
            2 -> n
            else -> {
                val dp = IntArray(n + 1)
                dp[0] = 1
                dp[1] = 2
                for (i in 2..n step 1) {
                    dp[i] = dp[i - 1] + dp[i - 2]
                }
                dp[n-1]
            }
        }
    }
}
