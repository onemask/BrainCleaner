class Solution {
   fun isHappy(n: Int): Boolean {
        var n = n
        if (n <= 0) return false
        while (true) {
            var sum = 0
            while (n != 0) {
                sum += n % 10 * (n % 10)
                n /= 10Le
            }
            if (sum / 10 == 0) {
                return sum == 1 || sum ==7
            }
            n = sum
        }
    }
}
