
/**
 * Created by jiawen.chen on 2019/7/27.
 */
import java.util.*;
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class q23_PrintFromTopToBottom_从上往下打印二叉树 {

    //非递归方法
    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        LinkedList<TreeNode> q=new LinkedList<TreeNode>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        if(root==null)
            return ans;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            ans.add(node.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
        }
        return ans;
    }


    //非递归方法
   private ArrayList<Integer> ans=new ArrayList<Integer>();

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        int height=getHeight(root);
        for(int h=1;h<=height;h++)
        {
            levelOrder(root,h);
        }
        return ans;
    }

    private void levelOrder(TreeNode root,int h){
        if(root==null) return ;
        if(h==1) ans.add(root.val);
        levelOrder(root.left,h-1);
        levelOrder(root.right,h-1);
    }

    private int getHeight(TreeNode root)
    {
        if(root==null) return 0;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left,right)+1;
    }
}
