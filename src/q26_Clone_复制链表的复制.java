/**
 * 思路1：首先想到的思路，时间复杂度为O(n^2)，先将单链表next复制完，再复制random指针
 * 思路2：时间复杂度O(n)，直接将复制的结点追加在原结点的末尾，然后进一步复制random指针，最后将原链表和复制链表分离
 * Created by jiawen.chen on 2019/7/30.
 */
public class q26_Clone_复制链表的复制 {
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode node = pHead;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode newNode = newHead;
        //复制单链表
        while ((node = node.next) != null) {
            newNode.next = new RandomListNode(node.label);
            newNode = newNode.next;
        }
        node = pHead;
        newNode = newHead;
        //复制random指针
        while (node != null) {
            newNode.random = find(node, newHead);
            node = node.next;
            newNode = newNode.next;
        }
        return newHead;
    }


    private RandomListNode find(RandomListNode targetNode, RandomListNode newHead) {
        if (targetNode.random == null) return null;
        int target = targetNode.random.label;
        RandomListNode newNode = newHead;
        while (newNode != null) {
            if (newNode.label == target) return newNode;
            newNode = newNode.next;
        }
        return null;
    }


    //思路2
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode node = pHead;
        //将复制结点追加到原结点后面
        while (node != null) {
            RandomListNode temp = new RandomListNode(node.label);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        node = pHead;
        //复制random指针
        while (node != null && node.next != null) {
            if (node.random == null) {
                node.next.random = null;
            } else node.next.random = node.random.next;
            node = node.next.next;
        }

        //链表分离
        RandomListNode head = pHead;
        RandomListNode newHead = pHead.next;
        while (head != null) {
            RandomListNode chead = head.next;
            head.next = chead.next;
            chead.next = (chead.next == null) ? null : chead.next.next;
            chead = chead.next;
            head = head.next;
        }
        return newHead;
    }
}