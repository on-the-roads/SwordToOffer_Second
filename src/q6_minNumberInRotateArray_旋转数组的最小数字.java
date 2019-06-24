public class q6_minNumberInRotateArray_旋转数组的最小数字 {
    //思路1
    public int minNumberInRotateArray_1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        return array[0];
    }

    //思路2
    public int minNumberInRotateArray_2(int[] array) {
        int l = 0;//l为左边递增数组的指针
        int r = array.length - 1;//r为右边递增数组的指针
        while (array[l]>=array[r]) {
            if(r-l==1)//l指向左边递增数组的最后一位，r指向右边递增数组的第一位
                return  array[r];
            int mid = (l + r) / 2;
            if(array[mid]==array[0]&&array[0]==array[array.length-1])//当左右及中间元素都相同时，无法判断最小元素在哪一边，这时候只能从左向右遍历来查找
                return minNumberInRotateArray_1(array);
            if (array[mid] >=array[l])
                l = mid;
            else if (array[mid] <=array[r])
                r = mid;
            else
                return array[mid];
        }
        return array[l];//当最左边元素小于最右边元素，最小值一定是最左边元素
    }

    public static void main(String[] args) {
        int ans=new q6_minNumberInRotateArray_旋转数组的最小数字().minNumberInRotateArray_2(new int[]{1,2,2,2,2,2});
        System.out.println(ans);
    }
}
