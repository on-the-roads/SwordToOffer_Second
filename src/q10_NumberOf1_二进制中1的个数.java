public class q10_NumberOf1_二进制中1的个数 {
    public int NumberOf1(int n) {
        public int NumberOf1 ( int n){
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n = n >>> 1;
            }
            return count;
        }
    }
}
