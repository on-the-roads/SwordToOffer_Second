/**
 * Created by jiawen.chen on 2019/7/31.
 */

import java.util.*;

public class q28_Permutation_字符串的排列 {
    private ArrayList<String> ans = new ArrayList<String>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return ans;
        char[] chs = str.toCharArray();
        find(chs, 0, chs.length - 1);
        Collections.sort(ans);
        return ans;
    }


    private void find(char[] chs, int l, int r) {
        if (l == r) {
            ans.add(String.valueOf(chs));
            return;
        }
        for (int i = l; i <= r; i++) {
            if (i != l && chs[i] == chs[l]) continue;
            swap(chs, i, l);
            find(chs, l + 1, r);
            swap(chs, i, l);
        }
    }

    private void swap(char[] chs, int a, int b) {
        char temp = chs[a];
        chs[a] = chs[b];
        chs[b] = temp;
    }
}