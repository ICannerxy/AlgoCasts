import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author icanner
 * @date 2020/4/1510:30 下午
 * @description: 判断二叉树是否中轴对称
 *      1
 *    2   2
 *   4 8 8 4
 * 这个二叉树就是中轴对称的
 */
public class 对称二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        对称二叉树 treeNode = new 对称二叉树();
        boolean isSymmetric = treeNode.isSymmetricTreeIterative(new TreeNode(10));
        System.out.println(isSymmetric);
    }


    /**
     * 递归判断 T:O(n) S:O(n)
     * 思路： 判断两个节点的值相等
     * 并且左子树的左节点值和右子树的右节点值相等
     * 并且左子树的右节点值和右子树的左节点值相等
     * @param s
     * @param t
     * @return
     */
    boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            return s.val == t.val && isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
        } else {
            return s == null && t == null;
        }
    }

    public boolean isSymmetricTreeRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }


    /**
     * 思路：循环迭代 T:O(n) S:O(n)
     * 利用栈数据结构来存储节点数据
     * push左右节点进栈，在while循环中pop出栈，判断节点值是否相等
     * 如果相等，则继续while循环（因为栈中可能有很多数据了，所以不能直接返回true）
     * 如果不相等或者其中一个为null，则返回false
     * 再push左子树的左节点和右子树的右节点，push左子树的右节点和右子树的左节点
     *
     * @param root
     * @return
     */
    public boolean isSymmetricTreeIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode s = stack.pop(), t = stack.pop();
            if (s == null && t == null) {
                continue;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            stack.push(s.left);
            stack.push(t.right);
            stack.push(s.right);
            stack.push(t.left);
        }
        return true;
    }



}
