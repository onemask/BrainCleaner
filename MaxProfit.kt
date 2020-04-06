class Solution {
   fun maxProfit(prices: IntArray): Int {
        var answer = 0
        prices.forEachIndexed { index, v ->
            for (idx in index + 1..prices.lastIndex) {
                if (v > prices[idx])
                    break
                else {
                    answer += prices[idx] - prices[index]
                    break
                }
            }
        }
        return answer
    }
}
