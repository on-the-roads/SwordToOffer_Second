import java.util.ArrayList;

/**
 *  题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

 * 思路1：利用栈实现倒序
 * 思路2: 递归（本质上也是栈）
 */
public class q3_printListFromTailToHead__从尾到头打印链表 {
    ArrayList<Integer> res=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null)
            return res;
        return  add(listNode);
    }

    private ArrayList<Integer> add(ListNode listNode) {
        if(listNode!=null)
        {
            if(listNode.next!=null)
            {
                add(listNode.next);
            }
            res.add(listNode.val);
        }
        return res;
    }
}
