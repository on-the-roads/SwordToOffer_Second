/**
 * Created by jiawen.chen on 2019/8/2.
 */
public class q32_NumberOf1Between1AndN_Solution_从1到n整数中1出现的次数 {
    /**
     * 思路1，从1到n遍历，统计每个数中包含的1的个数，累加，时间复杂度O(n*log(10) n)
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution1(int n) {
        if (n <= 0) return 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numOf1(i);
        }
        return ans;
    }

    private int numOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            if (n % 10 == 1) cnt++;
            n = n / 10;
        }
        return cnt;
    }


    /**
     * 思路2: 写一个函数，能够统计具体位上1出现的次数，然后对n的每一位计算1的次数，相加，时间复杂度有所降低
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        if (n <= 0) return 0;
        int ans = 0;
        int wei = 0;
        int target = n;
        while (target != 0) {
            ans += numOf1(target % 10, wei, n);
            target = target / 10;
            wei++;
        }
        return ans;
    }


    private int numOf1(int ele, int wei, int n) {
        int base = 1;
        for (int i = 0; i < wei; i++) base *= 10;
        if (ele == 0)
            return n / (base * 10) * base;
        if (ele == 1)
            return n / (base * 10) * base + n % base + 1;
        return (n / (base * 10) + 1) * base;
    }

    /**
     * 思路3：思路同思路2，进一步优化思路2
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution3(int n) {
        if (n <= 0) return 0;
        int base = 1;
        int ans = 0;
        int target = n;
        while (target != 0) {
            int before = n / (base * 10);
            int after = n % base;
            int cur = n % (base * 10) / base;
            if (cur == 0)
                ans += before * base;
            else if (cur == 1)
                ans += before * base + after + 1;
            else
                ans += (before + 1) * base;
            base = base * 10;
            target = target / 10;
        }
        return ans;
    }


}
