/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
   fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null)
            return 0
        val dis = depth(root.left) + depth(root.right)
        val left_dis = diameterOfBinaryTree(root.left)
        val right_dis = diameterOfBinaryTree(root.right)
        return Math.max(dis, Math.max(left_dis, right_dis))
    }
    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val max = Math.max(depth(root.left), depth(root.right)) + 1
        return max
    }
}
