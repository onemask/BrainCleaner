class Solution {
   fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1).apply { this[0] = 1 }
        for (coin in coins)
            for (currAmt in 1..amount)
                if (currAmt >= coin)
                    dp[currAmt] += dp[currAmt - coin]
        return dp[amount]
    }
}
