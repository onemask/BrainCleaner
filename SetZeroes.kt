class Solution {
   fun setZeroes(matrix: Array<IntArray>): Unit {
        //0 이 있는 position을 찾는 list
        val zeroPosition = mutableListOf<Pair<Int, Int>>()

        //0이 있는 y,x 좌표 찾아라~
        matrix.forEachIndexed { idx_y, yv ->
            yv.forEachIndexed { idx_x, xv ->
                if (xv == 0) {
                    zeroPosition.add(idx_y to idx_x)
                }
            }
        }

        //0이 있는 y,x 좌표에서 인접 좌표들을 0으로 만들어라~
        zeroPosition.forEach { position ->
            makeZero(position.first, null, matrix).apply {
              makeZero(null, position.second, this).toMutableList()
            }
        }
    }

    private fun makeZero(idx_y: Int? = null, idx_x: Int? = null, matrix: Array<IntArray>): Array<IntArray> {
        val y = mutableListOf<Int>()

        //matix의 y 크기만큼 y 행을 만들어
        repeat(matrix[0].count()) {
            y.add(0)
        }

        //y 행을 matrix 에 같다 붙여
        idx_y?.let {
            matrix[idx_y] = y.toIntArray()
        }

        //x는 좀 복잡해.. x가 0 이 였던 좌표를 아니까 그 좌표에 해당하는 애들을 다 0으로 만들어
        idx_x?.let {
            matrix.forEachIndexed { iy, vy ->
                vy.forEachIndexed { ix, xv ->
                    if (it == ix) {
                        matrix[iy][ix] = 0
                    }
                }
            }
        }
        return matrix
        }
}}
