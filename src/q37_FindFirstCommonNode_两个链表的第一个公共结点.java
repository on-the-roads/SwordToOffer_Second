import java.util.*;

public class q37_FindFirstCommonNode_两个链表的第一个公共结点 {
    /**
     * 使用栈来实现后续遍历，从而找到公共结点
     * 时间复杂度O(m+n),空间复杂度O(m+n)
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode pub = null;
        if (pHead1 == null || pHead2 == null) return pub;
        Stack<ListNode> s1 = new Stack<ListNode>();
        ListNode node1 = pHead1;
        while (node1 != null) {
            s1.push(node1);
            node1 = node1.next;
        }
        Stack<ListNode> s2 = new Stack<ListNode>();
        ListNode node2 = pHead2;
        while (node2 != null) {
            s2.push(node2);
            node2 = node2.next;
        }

        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode temp1 = s1.pop();
            ListNode temp2 = s2.pop();
            if (temp1 != temp2)
                break;
            else
                pub = temp1;
        }
        return pub;
    }

    /**
     * 首先遍历获得两个链表的长度，然后将长度较长的结点向后遍历，使其与较短链表到末尾的长度保持一致，然后一起向后遍历找到相同的结点
     *  时间复杂度O(m+n)，没有用到空间，相比做法1更优
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode node1 = pHead1;
        int len1 = getLen(node1);
        ListNode node2 = pHead2;
        int len2 = getLen(node2);
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;

    }


    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }


}