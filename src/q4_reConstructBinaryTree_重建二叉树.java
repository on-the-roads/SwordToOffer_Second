public class q4_reConstructBinaryTree_重建二叉树 {

    private int[] pre;
    private int[] in;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length)
            return null;
        this.pre = pre;
        this.in = in;
        return build(0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode build(int start_pre, int end_pre, int start_in, int end_in) {
        TreeNode root = new TreeNode(pre[start_pre]);
        //在中序遍历序列中找到根节点对应位置
        int root_in=start_in;
        while(root_in<in.length&&in[root_in]!=root.val)
            root_in++;
        if(root_in==in.length-1&&in[root_in]!=root.val)
            return root;//找不到对应元素说明序列有问题
        int leftLength=root_in-start_in;//中序遍历序列中左子序列的长度
        int leftendPreorder=start_pre+leftLength;//先序遍历序列中左子序列最后的下标处
        if (leftLength > 0) {
            //继续构建左子树
            root.left=build(start_pre+1,leftendPreorder,start_in,root_in-1);
        }
        if(leftLength<end_pre-start_pre)
        {
            //继续构建右子树
            root.right=build(leftendPreorder+1,end_pre,root_in+1,end_in);
        }
        return  root;
    }

    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode root=new q4_reConstructBinaryTree_重建二叉树().reConstructBinaryTree(pre,in);
    }
}
