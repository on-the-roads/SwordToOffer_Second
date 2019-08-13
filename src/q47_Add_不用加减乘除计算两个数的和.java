/**
 * 三步走战略：
 * 1. 先计算各位的和sum，不考虑进位，通过^实现
 * 2. 计算求和过程中产生的进位carry，通过&操作再左移一位实现
 * 3. 如果进位为0，则异或结果sum就是所求结果，否则进行将sum和carry看做两个待相加的数继续上述1和2步骤
 */
public class q47_Add_不用加减乘除计算两个数的和 {
    public int Add(int num1, int num2) {
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        while (carry != 0) {
            int temp1 = sum;
            sum = sum ^ carry;
            carry = (temp1 & carry) << 1;
        }
        return sum;
    }
}
