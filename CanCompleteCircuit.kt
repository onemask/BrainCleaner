class Solution {
     fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        gas.zip(cost).forEachIndexed { index, item ->
            var newIndex = 1+index
            newIndex %= gas.size
            var sum = item.first - item.second
            while (0 <= sum && newIndex != index) {
                sum += gas[newIndex] - cost[newIndex]
                newIndex += 1
                newIndex %= gas.size
            }
            if (newIndex == index && 0 <= sum) return index
        }
        return -1

    }
}
