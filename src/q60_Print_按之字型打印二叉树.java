import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class q60_Print_按之字型打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList();
        if (pRoot == null) return ansList;
        LinkedList<TreeNode> queue = new LinkedList();
        int cnt = 1;
        queue.offer(pRoot);
        while (queue.size() != 0) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            while (size > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                size--;
            }
            if (cnt % 2 == 0)
                Collections.reverse(list);
            ansList.add(list);
            cnt++;
        }
        return ansList;
    }
}
