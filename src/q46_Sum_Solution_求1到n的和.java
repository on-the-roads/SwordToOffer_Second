/**
 * 使用&&操作来代替if判断条件能够继续执行
 * 递归思想
 */
public class q46_Sum_Solution_求1到n的和 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean judge = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
