/**
 * 思路：维护两个栈，一个栈用于存放和取出元素，一个栈用于存放和取出最小元素
 * Created by jiawen.chen on 2019/7/26.
 */

import java.util.Stack;

public class q21_包含min函数的栈 {
    private Stack<Integer> ns = new Stack<Integer>();
    private Stack<Integer> mins = new Stack<Integer>();

    public void push(int node) {
        ns.push(node);
        //当最小元素栈为空时，将下一个要存放进来的元素存入最小元素栈
        if (mins.isEmpty())
            mins.push(node);
        //当最小元素栈不为空时，当新存入的元素小于等于最小元素栈顶元素时，存入最小元素栈
        else if (node <= mins.peek())
            mins.push(node);
    }

    public void pop() {
        //当将元素弹出时，判断弹出的元素是否与最小元素栈顶元素相等，相等则弹出
        if (ns.pop() == mins.peek())
            mins.pop();
    }

    public int top() {
        return ns.peek();
    }

    public int min() {
        return mins.peek();
    }
}