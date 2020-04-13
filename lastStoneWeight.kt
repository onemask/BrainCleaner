class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        stones.sort()
        var idx = 1
        var mStones = stones.sortedArray()

        while (mStones.size > 1) {
            mStones = mStones.sortedArray()
            val first = mStones[mStones.size - 1]
            val second = mStones[mStones.size - 2]
            val value = first - second
            if (value > 0)                //first 가 더 큰 경우
            {
                mStones = mStones.sliceArray(0..mStones.size - 2)
                mStones[mStones.size - 1] = value
            } else {
                if (mStones.size >2) {
                    mStones = mStones.sliceArray(0..mStones.size - 3)
                }
                else
                    return 0
            }
        }
        return mStones.first()
    }
}
