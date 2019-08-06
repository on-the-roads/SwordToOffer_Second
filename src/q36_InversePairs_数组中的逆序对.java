/**
 * 由归并排序演变，将数组递归拆分为左右两个部分
 * （i）左边最大数字大于右边最大数字，构成逆序对，逆序数+=右边数组长度，将左边数字放在临时数组中，临时数组和左边数组指针都向前移动一位
 * (ii) 左边最大数字小于等于右边最大数字，则将右边数字放在临时数组中，临时数组和右边数组指针都向前移动一位
 * <p>
 * 其中就相当于在归并排序中判断了左边数组最大元素和右边数组最大元素的大小关系，然后对逆序对count进行更新
 */
public class q36_InversePairs_数组中的逆序对 {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        return MergeSort(array, 0, array.length - 1);
    }

    private int MergeSort(int[] arr, int L, int R) {
        if (L < R) {
            int mid = L + (R - L) / 2;
            int leftCount = MergeSort(arr, L, mid);
            int rightCount = MergeSort(arr, mid + 1, R);
            int count = 0;
            int Ls = L;
            int Le = mid;
            int Rs = mid + 1;
            int Re = R;
            int[] temp = new int[Re - Ls + 1];
            int point = Re - Ls;
            while (Le >= Ls || Re >= Rs) {
                if (Le >= Ls && Re >= Rs) {
                    //左边最大数字大于右边最大数字
                    if (arr[Le] > arr[Re]) {
                        count += Re - Rs + 1;
                        if (count >= 1000000007)
                            count = count % 1000000007;
                        temp[point--] = arr[Le--];
                    }
                    //左边最大数字小于等于右边最大数字
                    else
                        temp[point--] = arr[Re--];
                }
                //右边数组元素已遍历完
                else if (Le >= Ls) temp[point--] = arr[Le--];
                    //左边数组元素已遍历完
                else temp[point--] = arr[Re--];

            }
            //利用临时数组对左右两个数组进行重新排序，然后重新赋给原来的数组arr
            for (int i = 0; i < temp.length; i++) arr[Ls + i] = temp[i];
            return (leftCount + rightCount + count) % 1000000007;
        }
        return 0;
    }
}
