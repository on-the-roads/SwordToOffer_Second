/**
 * 思路：该题要考虑n位数是大数的情况，所以构建字符数组，每一位都有‘0’-‘9’的可能性，达到最后一位后输出，输出过程中过滤掉开头为0的情况
 */
public class q12_Print1ToMaxOfNDigits_打印1到最大的n位数 {
    public void Print1ToMaxOfNDigits(int n) {
        if (n < 1)
            return;
        char[] num = new char[n];
        addMore(num, n, 0);
    }

    private void addMore(char[] num, int n, int index) {
        if (index == n) {
            Print(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index] = (char) (i + '0');
            addMore(num, n, index + 1);
        }
    }

    private void Print(char[] num) {
        boolean isBegining0=true;
        for (char ch : num){
            if(isBegining0&&ch!='0')
                isBegining0=false;
            if(!isBegining0)
            System.out.print(ch);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        new q12_Print1ToMaxOfNDigits_打印1到最大的n位数().Print1ToMaxOfNDigits(9);
    }
}
