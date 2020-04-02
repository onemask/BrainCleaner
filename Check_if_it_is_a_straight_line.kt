class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        var answer = false
        val dy = (coordinates[1][1] - coordinates[0][1]).toDouble()
        val dx = (coordinates[1][0] - coordinates[0][0]).toDouble()
        val initalSlope = dy / dx

        for (i in 2 until coordinates.size) {
            val ddy = (coordinates[i][1] - coordinates[i - 1][1]).toDouble()
            val ddx = (coordinates[i][0] - coordinates[i - 1][0]).toDouble()
            val slope = ddy/ddx
            answer = initalSlope == slope
        }
        return answer
    }
}
