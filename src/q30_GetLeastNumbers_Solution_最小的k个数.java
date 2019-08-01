/**
 * Created by jiawen.chen on 2019/8/1.
 */

import java.util.*;

public class q30_GetLeastNumbers_Solution_最小的k个数 {
    ArrayList<Integer> ans = new ArrayList<Integer>();

    //利用最大堆实现求topk最小问题
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || input.length < k) return ans;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue(k, comparator);
        for (int ele : input) {
            heap.add(ele);
            if (heap.size() > k) heap.poll();
        }


        Object[] arr = heap.toArray();
        for (Object o : arr)
            ans.add((int) o);
        return ans;

    }
}
