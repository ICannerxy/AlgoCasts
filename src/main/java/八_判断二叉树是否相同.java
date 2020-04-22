import java.util.Stack;

/**
 * @author icanner
 * @date 2020/4/2210:28 下午
 * @descrption: 判断两个二叉树是否完全相同，包括结构和数字
 */
public class 八_判断二叉树是否相同 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        八_判断二叉树是否相同 treeNodeControl = new 八_判断二叉树是否相同();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);

        System.out.println(treeNodeControl.isSameTreeIterative(treeNode1, treeNode2));
    }

    /**
     * 递归版本 Time: O(n) Space: O(n)
     * 思路: 分别比较相同对应节点的值, 如果都相等则返回true,其中一个为null,另一个不为null则返回false
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        return p.val == q.val && isSameTreeIterative(p.left, q.left) && isSameTreeIterative(p.right, q.right);
    }

    /**
     * 迭代版本: Time: O(n) Space: O(n)
     * 思路: 定义栈数据结构，
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.empty()) {
            TreeNode s = stack.pop(), t = stack.pop();
            if (s == null && t == null) {
                continue;
            }
            if (s == null || t == null){
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            stack.push(s.left);
            stack.push(t.left);
            stack.push(s.right);
            stack.push(t.right);
        }
        return true;
    }

}
