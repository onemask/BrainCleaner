class Solution {
   fun generateParenthesis(n: Int): List<String>? {
        val answer = mutableListOf<String>()
        backTracking(0, 0, "", n, answer)
        return answer
    }

    private fun backTracking(open: Int, close: Int, currentString: String, n: Int, answer: MutableList<String>) {
        //최대 글자 n*2 면 answerList에 넣기
        if (currentString.length == n * 2) {
            answer.add(currentString)
            return
        }
        //"(" 넣기
        if (open < n) {
            backTracking(open + 1, close, currentString.plus("("), n, answer)
        }
        //")" 넣기
        if (close < open) {
            backTracking(open, close + 1, currentString.plus(")"), n, answer)
        }
    }
}
