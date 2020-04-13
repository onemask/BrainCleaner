class Solution {
      fun makeQueue(stack: Stack<Char>, str: String): Stack<Char> {
        for (c in str) {
            if (c == '#') {
                if (stack.isNotEmpty()) {
                    stack.removeAt(stack.size - 1)
                }
            } else {
                stack.add(c)
            }
        }
        return stack
    }

    fun backspaceCompare(S: String, T: String): Boolean {
        var q_s: Stack<Char> = Stack()
        var q_t: Stack<Char> = Stack()
        var ss = ""
        var tt = ""
        q_s = makeQueue(q_s, S)
        q_t = makeQueue(q_t, T)
        while (q_s.isNotEmpty()) {
            ss += q_s.pop()
        }
        while (q_t.isNotEmpty()) {
            tt += q_t.pop()
        }
        return ss.reversed() == tt.reversed()
    }

}
