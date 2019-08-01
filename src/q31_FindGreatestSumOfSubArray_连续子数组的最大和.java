/**
 * Created by jiawen.chen on 2019/8/1.
 */

import java.util.*;

public class q31_FindGreatestSumOfSubArray_连续子数组的最大和 {

    //思路1：首先想到的思路
    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
            if (sum > max) max = sum;
            if (sum < 0) {
                sum = 0;
                max = 0;
            }
        }
        Arrays.sort(array);
        if (array[array.length - 1] < 0) return array[array.length - 1];
        return max;
    }

    //思路2：相比思路1，在遍历中就包含了数组全为负数的情况，不用去单独判断
    public int FindGreatestSumOfSubArray2(int[] array) {
            if(array==null||array.length==0) return 0;
            int cur=array[0];
            int max=array[0];
            for(int i=1;i<array.length;i++){
                cur=(cur>0)?cur+array[i]:array[i];
                if(cur>max) max=cur;
            }
            return max;
        }


        //思路3：动态规划，其实和思路2完全一致
        public int FindGreatestSumOfSubArray3(int[] array) {
            if(array==null||array.length==0) return 0;
            int[] dp=new int[array.length];
            int max=dp[0]=array[0];
            for(int i=1;i<array.length;i++){
                if(dp[i-1]<=0) dp[i]=array[i];
                else dp[i]=dp[i-1]+array[i];
                max=max>dp[i]?max:dp[i];
            }
            return max;
        }
    }


