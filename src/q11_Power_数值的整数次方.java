/**
 * 思路1：很容易想到的思路，利用循环不断乘底数。
 * 思路2：利用指定公式减少循环次数
 */
public class q11_Power_数值的整数次方 {
    public double Power(double base, int exponent) throws Exception {
        double ans = base;
//        if(exponent==0)//此处有问题，需要优化，不能用==判断double的相等
        if (Equals(base, 0) && exponent < 0)
            throw new Exception("分母不能为0");
        if(exponent==0)
            return (double)1;
        boolean sym = exponent < 0 ? false : true;
        exponent = Math.abs(exponent);

        //方法1
//        int i = 1;
//        while (i++ < exponent) {
//            ans = ans * base;
//        }

      //方法2
        ans=Power_2(base,exponent);
        return sym ? ans : 1 / ans;
    }

    private boolean Equals(double base, int i) {
        return Math.abs(base - i) < 0.0000001;
    }


    //思路2
    public double Power_2(double base, int exponent) {
        if(exponent==0)
            return 1;
        if(exponent==1)
            return  base;
        double res=Power_2(base,exponent>>>1);
        res*=res;
        if((exponent&1)==1)
            res*=base;
        return res;
    }

    public static void main(String[] args) throws Exception {
        double ans = new q11_Power_数值的整数次方().Power(2, -2);
        System.out.println(ans);
    }
}
