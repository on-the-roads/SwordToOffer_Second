/**
 * Created by jiawen.chen on 2019/7/25.
 */

import java.util.*;

/**
 * 思路：先遍历树1，找到和树2根节点root2值相同的node，然后将node和root2开始向下比较结构是否相同
 */
public class q18_HasSubtree_树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        inOrder(root1, root2);
        return flag;
    }

    private boolean flag = false;

    private void inOrder(TreeNode root, TreeNode target) {
        if (root != null) {
            inOrder(root.left, target);
            if (root.val == target.val && Do(root, target)) flag = true;
            inOrder(root.right, target);
        }
    }

    private boolean Do(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null) return false;
        if (node2 == null) return true;
        if (node1.val != node2.val) return false;
        return Do(node1.left, node2.left) && Do(node1.right, node2.right);
    }
}