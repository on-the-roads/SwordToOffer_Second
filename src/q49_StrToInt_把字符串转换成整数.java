public class q49_StrToInt_把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chs = str.toCharArray();
        if (!isLegal(chs[0])) {
            if (chs[0] == '+')
                return StrToInt(str.substring(1));
            if (chs[0] == '-')
                return -1 * StrToInt(str.substring(1));
            return 0;
        }
        int sum = 0;
        int carry = 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (!isLegal(chs[i])) return 0;
            sum += (chs[i] - '0') * carry;
            carry *= 10;
        }
        return sum;
    }

    private boolean isLegal(char ch) {
        return (ch >= '0' && ch <= '9');
    }
}
