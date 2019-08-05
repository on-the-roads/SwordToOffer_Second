import java.util.Arrays;
import java.util.Comparator;

/**
 * 该题最容易想到的思路是全排序，但是时间复杂度为O(n!)
 * 有更好的方法：难点在于自定义排序规则
 */
public class q33_PrintMinNumber_把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0) return "";
        String[] ss=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            ss[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(ss,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                String t1=s1+s2;
                String t2=s2+s1;
                return t1.compareTo(t2);
            }
        });
        StringBuilder sb=new StringBuilder();
        for(String str:ss)
            sb.append(str);
        return sb.toString();
    }
}
