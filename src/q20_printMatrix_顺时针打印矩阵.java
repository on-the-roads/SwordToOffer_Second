/**
 * Created by jiawen.chen on 2019/7/26.
 */

import java.util.ArrayList;

public class q20_printMatrix_顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix[0].length == 0) return list;
        int ri = 0;
        int ci = 0;
        int re = matrix.length - 1;
        int ce = matrix[0].length - 1;
        while (ri <= re && ci <= ce) {
            for (int col = ci; col <= ce; col++)
                list.add(matrix[ri][col]);
            for (int row = ri + 1; row <= re; row++)
                list.add(matrix[row][ce]);
            for (int col = ce - 1; col >= ci; col--) {
                if (ri == re) break;//防止矩阵只有一行，重复打印
                list.add(matrix[re][col]);
            }
            for (int row = re - 1; row >= ri + 1; row--) {
                if (ci == ce) break;//防止矩阵只有一列，重复打印
                list.add(matrix[row][ci]);
            }
            ri++;
            ci++;
            re--;
            ce--;
        }
        return list;
    }
}