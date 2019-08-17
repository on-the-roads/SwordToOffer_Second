import java.util.LinkedList;

public class q59_isSymmetrical_对称的二叉树 {

    //递归方法
    boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSym(pRoot.left, pRoot.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSym(left.right, right.left) && isSym(left.left, right.right);
    }

    //非递归方法
    boolean isSymmetrical2(TreeNode pRoot) {
        {
            if (pRoot == null) return true;
            LinkedList<TreeNode> queue = new LinkedList();
            queue.offer(pRoot.left);
            queue.offer(pRoot.right);
            while (queue.size() != 0) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if (left == null && right != null) return false;
                if (left != null && right == null) return false;
                if (left != null && right != null) {
                    if (left.val != right.val) return false;
                    queue.offer(left.left);
                    queue.offer(right.right);
                    queue.offer(left.right);
                    queue.offer(right.left);
                }
            }
            return true;
        }
    }
}
