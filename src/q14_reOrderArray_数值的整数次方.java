public class q14_reOrderArray_数值的整数次方 {
    //1. 允许扩展空间
    public void reOrderArray(int[] array) {
        int[] res = new int[array.length];
        if (array == null || array.length == 0)
            return;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1)
                res[index++] = array[i];
        }
        index = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0)
                res[index--] = array[i];
        }
        for (int i = 0; i < res.length; i++) {
            array[i] = res[i];
        }
    }

    //2.不允许扩展空间
    public void reOrderArray_2(int[] array) {
        if (array == null || array.length == 0)
            return;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j]%2==0&&array[j+1]%2==1)
                    Swap(array,j,j+1);
            }
        }
    }

    //3.如果没要求奇偶顺序相对不变， 考虑用双指针实现

    private void Swap(int[] array, int j, int i) {
        int temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }
}
