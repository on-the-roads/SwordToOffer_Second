import java.util.Stack;

/**
 * 两种方法：递归方法和非递归方法，本质上都是在中序遍历思路上做文章
 * Created by jiawen.chen on 2019/7/30.
 */
public class q27_Convert_二叉搜索树与双向链表 {

    private TreeNode head = null;
    private TreeNode end = null;

    public TreeNode Convert1(TreeNode pRootOfTree) {
        convert(pRootOfTree);//递归方法
        return head;
    }


    private void convert(TreeNode root) {
        if (root == null) return;
        convert(root.left);
        //遍历到最小的结点时初始化head和end结点，之后就会不断更新node结点，形成链表
        if (end == null) {
            head = root;
            end = root;
        }
        //更新链表尾结点
        else {
            end.right = root;
            root.left = end;
            end = root;
        }
        convert(root.right);
    }


    //非递归方法
    public TreeNode Convert2(TreeNode pRootOfTree) {
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode node=pRootOfTree;
        while(!s.isEmpty()||node!=null){
            while(node!=null){
                s.push(node);
                node=node.left;
            }
            if(!s.isEmpty()){
                node=s.pop();
                if(end==null){
                    head=node;
                    end=node;
                }
                else{
                    end.right=node;
                    node.left=end;
                    end=node;
                }
                node=node.right;
            }
        }
        return head;
    }



}