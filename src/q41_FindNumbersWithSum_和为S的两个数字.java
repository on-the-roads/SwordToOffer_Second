import java.util.ArrayList;

/**
 * 思路：双指针
 */
public class q41_FindNumbersWithSum_和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length <= 1) return list;
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int t1 = array[l];
            int t2 = array[r];
            int temp = t1 + t2;
            if (temp == sum) {
                list.add(t1);
                list.add(t2);
                break;
            }
            if (temp < sum) {
                l++;
            } else
                r--;
        }
        return list;
    }
}
