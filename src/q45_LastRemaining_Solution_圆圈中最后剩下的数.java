public class q45_LastRemaining_Solution_圆圈中最后剩下的数 {

    /**
     * 思路一：根据规律找迭代公式
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }


    /**
     * 思路2：利用环形链表实现
     */
    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) return -1;
        ListNode node = new ListNode(0);
        ListNode root = node;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = root;
        ListNode pre = null;
        //当链表中只要一个元素时终止循环
        while (node.next != node) {
            for (int i = 0; i < m; i++) {
                pre = node;
                node = node.next;
            }
            pre.next = node.next;
            node = pre;
        }
        return node.val;
    }


    class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        int val = new q45_LastRemaining_Solution_圆圈中最后剩下的数().LastRemaining_Solution2(5, 3);
    }
}
