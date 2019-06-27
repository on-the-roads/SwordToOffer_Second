/**题目：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class q4_replaceSpace_替换空格 {
    //思路1：开辟新的空间进行转换
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //思路2：在原来的空间基础上进行改动
    public String replaceSpace_2(StringBuffer str) {
        int numOfSpace = 0;
        int left = str.length() - 1;//左指针
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {//有一个空格就增加两个字符的长度
                numOfSpace++;
            }
        }
        str.append(new char[numOfSpace * 2]);
        int right = str.length() - 1;//右指针
        while (numOfSpace > 0) {
            if (str.charAt(left) == ' ') {
                str.setCharAt(right--, '0');
                str.setCharAt(right--, '2');
                str.setCharAt(right--, '%');
                left--;
                numOfSpace--;
            } else
                str.setCharAt(right--, str.charAt(left--));
        }
        return str.toString();
    }


    public static void main(String[] args) {
        String ans = new q4_replaceSpace_替换空格().replaceSpace_2(new StringBuffer("We are happy."));
        System.out.println(ans);
    }
}
