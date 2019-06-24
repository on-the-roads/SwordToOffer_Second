public class q9_Fibonacci_斐波那契数列 {
    public int Fibonacci(int n) {
        int a0=0;
        int a1=1;
        if(n==0)
            return a0;
        if(n==1)
            return a1;
        int i=2;
        int a_pre=0;
        int a=1;
        while(i++<=n)
        {
           int temp=a;
            a=a+a_pre;
            a_pre=temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int ans=new q9_Fibonacci_斐波那契数列().Fibonacci(5);
        System.out.println(ans);
    }
}
