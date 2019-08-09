import java.util.ArrayList;


/**
 * 思路：同样是双指针，不过这一次不是首尾指针，初始时，左指针在1的位置，右指针在2的位置
 * 当前和小于目标值时，右指针右移；
 * 当前和大于目标值时，左指针右移。
 */
public class q41_FindContinuousSequence_和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        if (sum <= 2) return ans;
        int l = 1;
        int r = 2;
        int cur = l + r;
        while (l < r && r <= (sum + 1) / 2) {
            if (cur == sum) {
                for (int i = l; i <= r; i++)
                    list.add(i);
                ans.add(new ArrayList(list));
                list.clear();
                r++;
                cur += r;
            } else if (cur < sum) {
                r++;
                cur = cur + r;
            } else {
                cur -= l;
                l++;
            }
        }
        return ans;
    }
}
