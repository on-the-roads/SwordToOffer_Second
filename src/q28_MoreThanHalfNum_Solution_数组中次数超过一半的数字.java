import java.util.Arrays;

/**
 * Created by jiawen.chen on 2019/7/31.
 */
public class q28_MoreThanHalfNum_Solution_数组中次数超过一半的数字 {

    //时间复杂度 O(logn)
    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length == 0) return 0;
        Arrays.sort(array);
        int mid = array.length / 2;
        int taget = array[mid];
        int count = 0;
        for (int i : array) {
            if (i == taget) count++;
            if (count > array.length / 2) return taget;
        }
        return 0;
    }



    /**
     * 时间复杂度O(n)，由于目标元素出现次数大于数组长度的一半，我们对每个元素维护一个次数cnt，初始时设为1，从数组初始位置开始遍历
     * 1.当后面一个元素与当前元素相同时，指针指向后一个元素，同时次数加1；
     * 2.当后面一个元素与当前元素不同时，次数减1，然后判断次数是否为0
     *   2.1 若次数不为0，则指针后移，继续判断
     *   2.2 若次数为0，则将指针后移，同时将次数重设为1
     *
     *
     *  将数组遍历完后，最后一次次数设为1 的元素就是要找的元素。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
            if(array==null||array.length==0) return 0;
            int result=array[0];
            int cnt=1;
            for(int i=0;i<array.length-1;i++){
                if(array[i]==array[i+1])
                    cnt++;
                else
                {
                    cnt--;
                    if(cnt==0) {
                        cnt=1;
                        result=array[i+1];
                    }

                }
            }
            return result;
        }
}
