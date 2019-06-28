public class q17_Merge_合并两个排序的链表 {

    //循环，双指针思路
    public ListNode Merge_1(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        if(p1==null)
            return p2;
        if(p2==null)
            return p1;
        ListNode head=null;
        if(p1.val<p2.val) {
            head = p1;
            p1=p1.next;
        }
        else {
            head = p2;
            p2=p2.next;
        }
        ListNode cur=head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur=cur.next;
        }
        while (p1 != null) {
            cur.next=p1;
            p1=p1.next;
            cur=cur.next;
        }
        while (p2 != null) {
            cur.next=p2;
            p2=p2.next;
            cur=cur.next;
        }
        return head;
    }


    //递归思想
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
        {
            return list1;
        }
        if(list1.val<list2.val)
        {
            list1.next= Merge(list1.next,list2);
            return list1;
        }
        else{
            list2.next= Merge(list1,list2.next);
            return list2;
        }
    }

        public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        head1.next=new ListNode(3);
        head1.next.next=new ListNode(5);
        ListNode head2=new ListNode(2);
        head2.next=new ListNode(4);
        head2.next.next=new ListNode(6);
        ListNode head=new q17_Merge_合并两个排序的链表().Merge(head1,head2);
    }
}
