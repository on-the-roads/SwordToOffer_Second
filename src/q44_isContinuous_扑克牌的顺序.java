import java.util.Arrays;

public class q44_isContinuous_扑克牌的顺序 {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length==0) return false;
        Arrays.sort(numbers);
        int len=numbers.length;
        int count0=0;
        int need0=0;
        for(int i=0;i<len;i++)
        {
            //非0元素重复则一定不能构成顺子
            if(i!=len-1&&numbers[i]!=0&&numbers[i]==numbers[i+1])
                return false;
            //统计0的个数
            if(numbers[i]==0)
            {
                count0++;
                continue;
            }
            //统计需要补0的个数
            if(i!=len-1){
                need0+=numbers[i+1]-numbers[i]-1;
            }
        }
        if(count0>=need0) return true;
        return false;
    }

}
