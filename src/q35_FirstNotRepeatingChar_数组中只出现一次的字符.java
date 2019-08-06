/**
 * 思路：扫描字符数组两次，第一次统计次数，第二次找到次数为1的字符即为所求结果。
 * 可以用hashMap或者数组来存储次数。
 * 由于字符全为字母，所以范围在56~122之间，我们可以建一个长度为123的数组。
 */
public class q35_FirstNotRepeatingChar_数组中只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0) return -1;
        char[] chs=str.toCharArray();
        int[] cnts=new int[123];
        for(char ch:chs){
            cnts[ch]++;
        }
        for(int i=0;i<chs.length;i++) if(cnts[chs[i]]==1) return i;
        return -1;
    }
}