import java.util.Arrays;

/**
 * 思路一：用数组或者hashmap存储元素出现次数
 * 思路二：不借助外部空间：
 * 1.首先对元素排序
 * 2.从最左边开始查找，定位到第i位
 * 3.如果数组中没有重复元素出现，则第i位元素应该为i，继续向后遍历；
 *   第i位不是i，而是m，说明数组中有重复元素【长度为n的数组里的所有数字都在0到n-1的范围内，所以能够判断有重复元素，这是个很重要的限定条件！】
 *  则查看数组中第m位是否为m，是则发现重复元素，返回结果；
 *  若第m位元素不是m，则将数组的第i位和第m位元素交换，保证第m位元素时m，继续3的循环，直到发现重复元素
 */
public class q51_duplicate_数值中重复的数字 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 1) return false;
        Arrays.sort(numbers);
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                int m = numbers[i];
                if (numbers[m] == m) {
                    duplication[0] = m;
                    return true;
                }
                numbers[i] = numbers[m];
                numbers[m] = m;
            }
        }
        return false;
    }
}
