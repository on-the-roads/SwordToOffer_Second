import java.util.Arrays;

public class q40_FindNumsAppearOnce_数组中只出现一次的数字 {

    /**
     * 思路1：由于数组中除了两个数字外，其他数字两两出现，因此首先想到的思路是
     * 对元素进行排序，
     * 从左边第一个元素开始向后隔一位遍历，后一位数字与该位不相同，则该位数就是要找的数之一；
     * 从右边最后一个元素开始向前隔一位进行遍历，前一位数字与该位不相同，则该位数就是要找的数之一；
     * 总时间复杂度为O(nlogn)
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i = i + 2) {
            if (array[i] != array[i + 1]) {
                num1[0] = array[i];
                break;
            }
        }

        for (int i = array.length - 1; i >= 1; i = i - 2) {
            if (array[i] != array[i - 1]) {
                num2[0] = array[i];
                break;
            }
        }
    }


    /**
     * 思路2：由两个相同的数异或结果为0可以想到，对整个数组进行异或，得到的结果至少有一位不为1
     * 我们找到第一个不为1的位数所对应的位置，记为第n位，以此位数来将数组分为两组，每组元素各自异或最后结果即为所求
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length==0) return;
        int temp=0;
        for(int a:array){
            temp=temp^a;
        }
        int index=0;
        while(temp!=0){
            if((temp&1)==1)
                break;
            temp=temp>>>1;
            index++;
        }
        get1Atindex(index,array,num1,num2);
    }


    private void get1Atindex(int index,int[] array,int[] num1,int[] num2){
        int compare=1;
        for(int i=0;i<index;i++)
            compare=compare<<1;
        for(int a:array){
            if((a&compare)==0)
                num1[0]^=a;
            else
                num2[0]^=a;
        }
    }
}
