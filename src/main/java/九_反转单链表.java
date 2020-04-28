/**
 * @author icanner
 * @date 2020/4/279:57 下午
 * @descrption 反转单链表
 */
public class 九_反转单链表 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * T: O(n) S:O(1)
     * 定义cur节点和节点，分别初始化
     * 当cur节点不为null时，先把cur.next节点记录下来
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
