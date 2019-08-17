/**
 * 思路：利用双指针，首先建立一个虚拟头结点，然后设置两个指针pre和cur
 * pre指向确定不会重复的结点，cur作为工作指针不断向后搜索
 */
public class q57_deleteDuplication_删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode vroot = new ListNode(-1);
        vroot.next = pHead;
        ListNode pre = vroot;
        ListNode cur = pHead;
        while (cur != null) {
            //有元素重复
            if (cur.next != null && cur.next.val == cur.val) {
                //向后搜索，直到链表末尾或者和下一个元素不相等
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                //将pre指针指向cur的下一元素，该元素确定不会和它的前驱结点元素相等
                pre.next = cur.next;
                cur = cur.next;

            }
            //当前结点为链表末尾结点或者当前元素和下一元素不相等，当前结点就是唯一的结点
            else {
                //pre指针指向该元素，并继续向下查找
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;

            }
        }
        return vroot.next;
    }
}
