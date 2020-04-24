/*
 * 문제 접근 방법
 * BinaryMatri의 row의 0, col의 last index부터 col을 -- 하며 접근 한다.
 * 0을 만나면 행을 +1 하여 아래로 가고 1을 만나면 col을 -1로 하여 왼쪽으로 간다. 
 */

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *     fun get(row:Int, col:Int):Int {}
 *     fun dimensions():List<Int> {}
 * }
 */
class Solution {
    fun leftMostColumnWithOne(binaryMatrix:BinaryMatrix):Int {
        val di = binaryMatrix.dimensions()
        var row = 0
        var col = -1+di[1] //last col index
        while (0 <= col && row < di[0]) {
            if (0 == binaryMatrix.get(row, col)) row += 1 //행을 아래로
            else col -= 1 //컬럼을 왼쪽으로
        }
        col += 1
        return if (col == di[1]) -1 else col //col이 마지막 index면 1이 없는 거니까 -1 아니면 col 
    }
}
