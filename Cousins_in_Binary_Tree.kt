/*
 Cousins 의 조건
 1. 서로 다른 조건을 가져야 한다.
 2. 서로 같은 depth를 가져야한다.
 */

class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        if (root == null)
            return false

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (queue.isEmpty().not()) {
            var xFlag = false
            var yFlag = false

            for (i in 0 until queue.size) {
                val current = queue.poll()

                //찾는 애면 각각의 flag를 true로
                when (current.`val`) {
                    x -> xFlag = true
                    y -> yFlag = true
                }

                //같은 depth를 가지나 같은 부모를 가지므로 탈락
                if (current.left != null && current.right != null) {
                    if (current.left!!.`val` == x && current.right!!.`val` == y) return false
                    if (current.left!!.`val` == y && current.right!!.`val` == x) return false
                }
                
                if (current.left != null) queue.offer(current.left)
                if (current.right != null) queue.offer(current.right)
            }
            
            if (xFlag && yFlag) {
                return true
            }
        }
        return false
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//For Test
fun main() {
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
    tree.right = TreeNode(3)
    tree.left!!.left = TreeNode(4)
    print("message ${LeetCode_Coussin().isCousins(tree, 4, 3)}")
}
