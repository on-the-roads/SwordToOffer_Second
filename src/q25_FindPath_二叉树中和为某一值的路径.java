/**
 * Created by jiawen.chen on 2019/7/29.
 */

import java.util.*;

public class q25_FindPath_二叉树中和为某一值的路径 {
    private ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return ans;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        find(root, target, 0, list);
        Collections.sort(ans, comparator);
        return ans;
    }


    private ArrayList<ArrayList<Integer>> find(TreeNode root, int target, int sum, ArrayList<Integer> list) {
        if (sum > target || root == null)
            return ans;
        if (root.left == null && root.right == null && sum + root.val == target) {
            ans.add(new ArrayList(list));
            return ans;
        }
        if (root.left != null) {
            list.add(root.left.val);
            find(root.left, target, sum + root.val, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            find(root.right, target, sum + root.val, list);
            list.remove(list.size() - 1);
        }
        return ans;

    }


    Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            //元素多的在前，元素少的在后
            return o2.size() - o1.size();
        }
    };


}