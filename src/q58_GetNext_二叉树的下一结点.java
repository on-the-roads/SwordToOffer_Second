public class q58_GetNext_二叉树的下一结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //当结点为空时
        if (pNode == null) return null;
        //当右子树不为空时，返回右子结点的最左子树
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        //逻辑走到这里，说明该结点只有左子树，要通过父结点进行判断
        //1.是父节点的左子结点，则直接返回父结点
        //2. 不是父节点的左子结点，则将父节点赋予当前结点，继续循环
        TreeLinkNode node = pNode;
        while (node.next != null) {
            TreeLinkNode fa = node.next;
            if (node == fa.left) return fa;
            node = fa;
        }
        //当前结点是根结点且没有右子树，则返回null
        return null;
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
