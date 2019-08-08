public class q34_GetUglyNumber_Solution_丑数 {
    /**
     * 首先想到的思路，后面一个丑数一定是由前面已有的丑数乘以 2、3、5得来的
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] arr = {0, 1, 2, 3, 4, 5};
        if (index <= 5) return arr[index];
        arr = new int[index + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = 5;

        int cnt = 6;
        int t2 = 1;
        int t3 = 1;
        int t5 = 1;
        int flag2 = Integer.MAX_VALUE;
        int flag3 = Integer.MAX_VALUE;
        int flag5 = Integer.MAX_VALUE;

        while (cnt <= index) {
            int temp = arr[cnt - 1];
            for (; t2 <= cnt - 1; t2++) {
                if (2 * arr[t2] > temp) {
                    flag2 = 2 * arr[t2];
                    break;
                }
            }
            for (; t3 <= cnt - 1; t3++) {
                if (3 * arr[t3] > temp) {
                    flag3 = 3 * arr[t3];
                    break;
                }
            }
            for (; t5 <= cnt - 1; t5++) {
                if (5 * arr[t5] > temp) {
                    flag5 = 5 * arr[t5];
                    break;
                }
            }
            arr[cnt] = Math.min(Math.min(flag2, flag3), flag5);
            if (arr[cnt] == flag5)
                t5++;
            if (arr[cnt] == flag3)
                t3++;
            if (arr[cnt] == flag2)
                t2++;

            cnt++;
        }
        return arr[index];
    }

    /**
     * 思路和做法2相同，对代码进行了简洁化，直接从第一个元素就开始执行循环，而不是初始化了5个元素
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution2(int index) {
        if(index<=0)
            return 0;
        if(index==1) return 1;
        int[] arr=new int[index+1];
        arr[1]=1;
        int t2=1;
        int t3=1;
        int t5=1;
        for(int i=2;i<=index;i++){
            int min=Math.min(Math.min(2*arr[t2],3*arr[t3]),5*arr[t5]);
            arr[i]=min;
            if(min==2*arr[t2])
                t2++;
            if(min==3*arr[t3])
                t3++;
            if(min==5*arr[t5])
                t5++;
        }
        return arr[index];
    }
}
