import java.util.LinkedList;

/**
 * Created by jiawen.chen on 2019/7/25.
 */
public class q19_Mirror_二叉树的镜像 {
    public void Mirror(TreeNode root) {
        change(root);//递归方法
        LevelOrder(root);//非递归方法，利用层序遍历思想
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    private TreeNode change(TreeNode root){
        if(root==null) return root;
        TreeNode temp=root.left;
        root.left=change(root.right);
        root.right=change(temp);
        return root;
    }


    /**
     * 非递归方法
     * @param root
     */
    private void LevelOrder(TreeNode root){
        if(root==null) return;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
    }
}