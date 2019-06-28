public class q16_ReverseList_反转链表 {
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode newn=null;
        ListNode old=head;
        while (old!=null)
        {
            ListNode temp=old.next;
            old.next=newn;
            newn=old;
            old=temp;
        }
        return newn;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode newHead=new q16_ReverseList_反转链表().ReverseList(head);
    }
}
