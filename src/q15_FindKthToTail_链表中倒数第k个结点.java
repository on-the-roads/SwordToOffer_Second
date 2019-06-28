//思路：双指针
public class q15_FindKthToTail_链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre = head;
        ListNode after = head;
        int i = 0;
        for (; i < k && after != null; i++) {
            after = after.next;
        }
        if (i < k)
            return null;//链表少于k个结点
        while (after != null) {
            pre = pre.next;
            after = after.next;
        }
        return pre;
    }
}
