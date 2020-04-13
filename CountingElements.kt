class Solution {
   fun countElements(arr: IntArray): Int {
        var answer = 0
        val mList = arr.sorted()
        mList.forEachIndexed { index, v ->
            for (i in index + 1..mList.size-1) {
                if (i <= mList.size-1) {
                    if (v + 1 == mList[i]) {
                        answer++
                        break
                    }
                }
            }
        }
        return answer
    }
}
