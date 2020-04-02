class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val zeroPosition = mutableListOf<Pair<Int, Int>>()
        var answer  = mutableListOf<IntArray>()
        matrix.forEachIndexed { idx_y, yv ->
            yv.forEachIndexed { idx_x, xv ->
                if (xv == 0) {
                    zeroPosition.add(idx_y to idx_x)
                }
            }
        }

        zeroPosition.forEach { position ->
            makeZero(position.first, null, matrix).apply {
                answer =makeZero(null, position.second, this).toMutableList()
            }
        }

        println("[")
        answer.forEach {
            println("${it.toList()}")
        }
        println("]")
    }

    fun makeZero(idx_y: Int? = null, idx_x: Int? = null, matrix: Array<IntArray>): Array<IntArray> {

        val y = mutableListOf<Int>()
        var myMatrix = matrix

        repeat(matrix[0].count()) {
            y.add(0)
        }


        idx_y?.let {
            myMatrix[idx_y] = y.toIntArray()
        }

        idx_x?.let {
            matrix.forEachIndexed { iy, vy ->
                vy.forEachIndexed { ix, xv ->
                    if (it == ix) {
                        myMatrix[iy][ix] = 0
                    }
                }
            }
        }

        return myMatrix
    }}
