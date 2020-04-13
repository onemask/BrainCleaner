class MinStack() {

    /** initialize your data structure here. */

    private var stack = Stack<Int>()
    private var list = mutableListOf<Int>()

    fun push(x: Int) {
        stack.add(x)
        list.add(x)
    }

    fun pop() {
        list.removeAt(list.lastIndexOf(stack.pop()))
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return list.min()!!
    }

}
/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
