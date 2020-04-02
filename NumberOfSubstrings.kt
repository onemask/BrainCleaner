class Solution {
    fun numberOfSubstrings(s: String): Int {
        val max = s.length-1
        var answer = 0
        val pos = mutableListOf(-1, -1, -1)

        for (idx in 0..max step 1) {
            pos[s[idx] - 'a'] = idx
            answer += Math.min(pos[0], Math.min(pos[1], pos[2])) + 1
        }
        return answer
}
}
