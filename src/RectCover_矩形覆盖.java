public class RectCover_矩形覆盖 {
    public int RectCover(int target) {
        if (target < 1)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int i = 2;
        int now = 2;
        int pre = 1;
        while (i++ < target) {
            int temp = now;
            now = now + pre;
            pre = temp;
        }
        return now;
    }
}
