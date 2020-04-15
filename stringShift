class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var answer = s
        
        shift.forEach {
            val direction = it[0]
            val amount = it[1]
            when (direction) {
                //left
                0 -> {
                    val left = answer.take(amount)
                    val right = answer.takeLast(s.length - amount)
                    answer = right.plus(left).toString()
                }
                //right
                1 -> {
                    val right = answer.takeLast(amount)
                    val left = answer.take(s.length - amount)
                    answer = right.plus(left).toString()

                }

            }
        }
        return answer
    }
}
