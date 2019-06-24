/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
//思路：从矩阵右上角开始查找，等于当前值则直接返回，小于当前值则横坐标左移一位；否则纵坐标下移一位；循环此过程，当元素下标越界则说明没找到。
public class q1_Find_二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0)
            return false;
        return find(array, 0, array[0].length - 1, target);//从矩阵的左上角开始查找
    }

    private boolean find(int[][] array, int row, int col, int target) {
        if (col < 0 || row >= array.length)
            return false;
        int cur = array[row][col];
        if (target == cur)
            return true;
        if (target < cur)
            return find(array, row, col - 1, target);
        else
            return find(array, row + 1, col, target);
    }
}
