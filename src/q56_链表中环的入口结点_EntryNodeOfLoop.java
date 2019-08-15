public class q56_链表中环的入口结点_EntryNodeOfLoop {
    /**
     * 思路1：利用快慢指针的进度关系找到规律
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast==null||fast.next == null)
            return null;
        ListNode newStart = pHead;
        while (slow != null && newStart != null) {
            if (slow == newStart) return slow;
            slow = slow.next;
            newStart = newStart.next;
        }
        return null;
    }

    /**
     * 思路2：断链法
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast==null||fast.next == null)
            return null;
        ListNode node = pHead;
        ListNode pre = null;
        while (node != null) {
            pre = node;
            node = node.next;
            pre.next = null;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode node=root;
        for (int i = 2; i <5 ; i++) {
            node.next=new ListNode(i);
            node=node.next;
        }
        ListNode ans=new q56_链表中环的入口结点_EntryNodeOfLoop().EntryNodeOfLoop2(root);

    }

}
