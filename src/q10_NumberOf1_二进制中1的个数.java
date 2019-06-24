/**
 * 思路：
 * 方法1：逐位与1相与，时间复杂度与n的二进制位数有关
 * 方法2: 优化思路，时间复杂度与n的二进制中1的个数有关，将数a减1的结果b与a相与，就可以把a的二进制中最右边的1变为0
 */
public class q10_NumberOf1_二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    //方法2
    public int NumberOf1_two(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int ans=new q10_NumberOf1_二进制中1的个数().NumberOf1_two(214748367);
        System.out.println(ans);
    }
}
