import kotlin.math.min


class Solution {
   fun countSquares(matrix: Array<IntArray>): Int {
        val y = matrix.size 
        val x = matrix[0].size

        val counts = IntArray(x) // 행의 크기만큼 배열을 만든다. 
        var topLeft = 0
        var result = 0

        for (yy in 0 until y) { 
            for (xx in 0 until x) {
                if (matrix[yy][xx] == 1) {
                    val top = if (yy == 0) 0 else counts[xx]
                    val left = if (xx == 0) 0 else counts[xx - 1]
                    counts[xx] = 1 + min(min(top, left), topLeft) //matix[yy][xx]==1 이면 각 top,left,topleft 의 min 값을 더한다.
                    result += counts[xx] //더한 값들을 다 result 로 
                    topLeft = if (xx == x - 1) 0 else top
                } else
                    counts[xx] = 0
            }
        }
        return result
    }
}
