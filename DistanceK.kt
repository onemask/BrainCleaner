class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        val stk = Stack<TreeNode>()
        if (!findTargetHelper(root, target, stk)) {
            return emptyList()
        }
        var cnt = 0
        var lastNode: TreeNode? = null
        val ans: MutableList<Int> = ArrayList()
        while (!stk.isEmpty()) {
            val node = stk.pop()
            ans.addAll(findChild(node, lastNode, K - cnt))
            cnt++
            lastNode = node
        }
        return ans
    }

    fun findTargetHelper(root: TreeNode?, target: TreeNode?, stk: Stack<TreeNode>): Boolean {
        if (root == null) {
            return false
        }
        stk.push(root)
        if (root == target)
            return true

        if (findTargetHelper(root.left, target, stk))
            return true

        if (findTargetHelper(root.right, target, stk))
            return true

        stk.pop()
        return false
    }

    fun findChild(root: TreeNode?, pre: TreeNode?, k: Int): List<Int> {
        if (root == null || k < 0 || root == pre) {
            return emptyList()
        }
        if (k == 0) {
            return listOf(root.`val`)
        }
        val ans: MutableList<Int> = ArrayList()
        ans.addAll(findChild(root.left, pre, k - 1))
        ans.addAll(findChild(root.right, pre, k - 1))
        return ans
    }
}
