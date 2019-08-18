import java.util.LinkedList;

public class q62_Serialize_序列化二叉树 {
    //层序遍历思路
    String Serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (node == null) sb.append("#");
            else {
                sb.append(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
            sb.append("!");
        }
        return sb.toString();
    }

    //层序遍历思路
    TreeNode Deserialize1(String str) {
        if (str == null || str.length() == 0) return null;
        String[] ss = str.split("!");
        LinkedList<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(Integer.valueOf(ss[0]));
        int len = ss.length;
        int index = 1;
        queue.add(root);
        while (queue.size() != 0 && index < len) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            String temp = ss[index++];
            if (temp.equals("#")) node.left = null;
            else
                node.left = new TreeNode(Integer.valueOf(temp));
            queue.offer(node.left);
            temp = ss[index++];
            if (temp.equals("#")) node.right = null;
            else
                node.right = new TreeNode(Integer.valueOf(temp));
            queue.offer(node.right);
        }
        return root;
    }


    //先序遍历思路
    String Serialize2(TreeNode root) {
        if (root == null) return "";
        return preOrder(root);
    }

    private String preOrder(TreeNode root) {
        if (root == null) return "#!";
        StringBuilder sb = new StringBuilder(String.valueOf(root.val) + "!");
        sb.append(preOrder(root.left));
        sb.append(preOrder(root.right));
        return sb.toString();
    }

    TreeNode Deserialize2(String str) {
        if (str == null || str.length() == 0) return null;
        LinkedList<String> queue = new LinkedList<String>();
        String[] ss = str.split("!");
        for (String s : ss) queue.offer(s);
        return buildTree(queue);
    }

    private TreeNode buildTree(LinkedList<String> queue) {
        String temp = queue.poll();
        if (temp.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(temp));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}
