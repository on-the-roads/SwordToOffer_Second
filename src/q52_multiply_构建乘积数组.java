/**
 * 思路：既然不能用除法，那就分段乘
 */
public class q52_multiply_构建乘积数组 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return A;
        int[] B = new int[A.length];
        B[0] = 1;
        //先计算B数组每个元素上左边的乘积和
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        //再计算B数组每个元素上右边的乘积和
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }
}
