/**
 * Created by jiawen.chen on 2019/7/27.
 */

import java.util.*;

/**
 * 总体思路都是借用一个辅助栈去根据压入序列和弹出序列去模拟压栈弹栈操作，看能够顺利走通
 */
public class q22_IsPopOrder_栈的压入弹出序列 {
    private Stack<Integer> s = new Stack<Integer>();


    //思路1
    public boolean IsPopOrder1(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length == 0) return true;
        int len = pushA.length;
        s.push(pushA[0]);
        int index = 1;
        for (int ele : popA) {
            if (ele == s.peek()) {
                s.pop();
                continue;
            }
            if (index >= len && !s.isEmpty())
                return false;
            for (; index < len; ) {
                s.push(pushA[index]);
                if (pushA[index++] == ele) {
                    s.pop();
                    break;
                }
            }
        }
        return true;
    }


    //思路2
    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length == 0) return true;
        int index = 0;
        for (int ele : pushA) {
            s.push(ele);
            while (!s.isEmpty() && s.peek() == popA[index]) {
                s.pop();
                index++;
            }
        }
        return s.isEmpty();
    }


}

