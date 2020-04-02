class Solution {
       fun findNthDigit(n: Int): Int {
        var n = n
        var digitLvl = 1
        var cnts: Long = 9
        while (n - digitLvl * cnts > 0) {
            n -= digitLvl * cnts.toInt()
            digitLvl++
            cnts *= 10
        }
        val startN = Math.pow(10.0, (digitLvl - 1.toDouble())).toInt()
        val finalN = startN + (n - 1) / digitLvl
        val whichDigit = (n - 1) % digitLvl
        return finalN.toString()[whichDigit] - '0'
    }
}
